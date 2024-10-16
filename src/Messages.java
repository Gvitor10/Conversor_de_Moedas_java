import java.util.Set;

public class Messages {
    String welcomeMessage = "*** Olá, seja bem-vindo(a) ao CONVERSOR DE MOEDAS ***\n";
    String amountInputMessage = "Digite o valor que deseja converter:";
    String[] menuMessage = {
            "*** Escolha uma dos opções abaixo ***\n",
            "1) 'BRL' - REAL BRASILEIRO -> 'USD' - DÓLAR AMERICANO",
            "2) 'BRL' - REAL BRASILEIRO -> 'EUR' - EURO",
            "3) 'BRL' - REAL BRASILEIRO -> 'GBP' - LIBRA ESTERLINA",
            "4) 'BRL' - REAL BRASILEIRO -> 'JPY' - IENE JAPONÊS",
            "5) 'USD' - DÓLAR AMERICANO -> 'BRL' - REAL BRASILEIRO",
            "6) 'EUR' - EURO            -> 'BRL' - REAL BRASILEIRO",
            "7) 'GBP' - LIBRA ESTERLINA -> 'BRL' - REAL BRASILEIRO",
            "8) 'JPY' - IENE JAPONÊS    -> 'BRL' - REAL BRASILEIRO\n",
            "9)  Mais opções...\n",
            "*** Digite 0 para encerrar o programa ***",
    };

    // Methods...
    public void showMessage(String text) {
        System.out.println(text);
    }

    public void listCoinsMessages(Set<String> text) {
        int number = 1;

        for (String line: text) {
            System.out.println((number) + ") " + line);
            number++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void showRollMessage(String[] text) {
        for (String line: text) {
            System.out.println(line);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
