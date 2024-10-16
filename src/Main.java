import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var messages = new Messages();
        var converter = new Converter();
        var input = new Scanner(System.in);
        int option = -1;
        boolean exit = false;

        messages.showMessage(messages.welcomeMessage);
        System.out.println("Digite a sua API Key para continuar:");
        converter.setApiKey(input.nextLine());

        // System cycle...
        do {
            messages.showRollMessage(messages.menuMessage);
            option = input.nextInt();

            switch (option) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    converter.setBaseCode("BRL");
                    converter.setTargetCode("USD");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 2:
                    converter.setBaseCode("BRL");
                    converter.setTargetCode("EUR");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 3:
                    converter.setBaseCode("BRL");
                    converter.setTargetCode("GBP");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 4:
                    converter.setBaseCode("BRL");
                    converter.setTargetCode("JPY");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 5:
                    converter.setBaseCode("USD");
                    converter.setTargetCode("BRL");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 6:
                    converter.setBaseCode("EUR");
                    converter.setTargetCode("BRL");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 7:
                    converter.setBaseCode("GBP");
                    converter.setTargetCode("BRL");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 8:
                    converter.setTargetCode("JPY");
                    converter.setBaseCode("BRL");
                    messages.showMessage(messages.amountInputMessage);
                    converter.pairConversion(input.nextDouble());
                    break;
                case 9:
                    converter.customConversion();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (exit == false);
    }
}
