import br.com.myApp.records.CustomConversion;
import br.com.myApp.records.PairConversion;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.Set;

public class Converter {
    String baseCode = "BRL";
    String targetCode;
    String apiKey;
    Messages messages = new Messages();

    // Setters
    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    // Methods
    public void pairConversion(double amount) {
        // Http request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCode + "/" + targetCode
                 + "/" + amount))
                .build();

        // http response
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            PairConversion newPairConversion = gson.fromJson(response.body(), PairConversion.class);

            System.out.println("**************************************************\n" +
                    "CONVERTENDO O VALOR DE: " + amount + " EM " + baseCode + "\n" +
                    "CORRESPONDE AO VALOR DE: " + newPairConversion.conversion_result()  + " EM " + targetCode + "\n" +
                    "**************************************************");

            Scanner input = new Scanner(System.in);
            input.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void customConversion() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCode))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Extracting name from coins...
            Gson gson = new Gson();
            CustomConversion newCustomConversion = gson.fromJson(response.body(), CustomConversion.class);
            Set<String> coinsName = newCustomConversion.conversion_rates().keySet();

            // Show coins name list...
            messages.listCoinsMessages(coinsName);

            Scanner input = new Scanner(System.in);
            System.out.println("*** Digite a moeda moeda de origem: ***");
            setBaseCode(input.nextLine());
            System.out.println("*** Digite a moeda que deseja converter: ***");
            setTargetCode(input.nextLine());
            messages.showMessage(messages.amountInputMessage);
            pairConversion(input.nextDouble());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
