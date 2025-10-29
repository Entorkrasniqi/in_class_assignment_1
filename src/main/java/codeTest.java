import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class codeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Language selection
        System.out.println("Select a language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int choice = readInt(scanner, "Enter 1-4: ");
        String language = "en";
        String country = "US";

        if (choice == 2) {
            language = "fi";
            country = "FI";
        } else if (choice == 3) {
            language = "sv";
            country = "SE";
        } else if (choice == 4) {
            language = "ja";
            country = "JP";
        }

        Locale locale = new Locale(language, country);
        ResourceBundle message = ResourceBundle.getBundle("messagesBundle", locale);
        String numberOfItemsMessage = message.getString("numberOfItemsMessage");
        String priceMessage = message.getString("priceMessage");
        String quantityMessage = message.getString("quantityMessage");
        String costMessage = message.getString("costMessage");

        int totalPrice = 0;

        System.out.println(numberOfItemsMessage + " ");
        while (true) {
            int price = readInt(scanner, priceMessage + " Enter -1 to exit: ");
            if (price == -1) break;

            int qty = readInt(scanner, quantityMessage + " ");
            totalPrice += price * qty;
        }

        System.out.println(costMessage + ": " + totalPrice);
        scanner.close();
    }

    // Simple safe int input that reprompts on invalid input
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            if (!prompt.isEmpty()) System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                return val;
            } else {
                // consume invalid token and reprompt
                String bad = scanner.next();
                System.out.println("Please enter a whole number (got: " + bad + ").");
            }
        }
    }
}