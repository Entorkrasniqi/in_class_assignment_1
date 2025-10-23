package inclassAssignment1;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class codeTest {
    public static void main(String[] args) {

        // choose English language
        Scanner scanner = new Scanner(System.in);
        int choise;
        String language = "en";
        String country = "US";
        int numberOfItems;
        int totalPrice = 0;


        // Print language
        System.out.println("Select a language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");
        choise = scanner.nextInt();

        if (choise == 1) {
            language = "en";
            country = "US";
        } else if (choise == 2) {
            language = "fi";
            country = "FI";
        } else if (choise == 3) {
            language = "sv";
            country = "SE";
        } else if (choise == 4) {
            language = "ja";
            country = "JP";
        }


        Locale locale = new Locale(language, country);
        ResourceBundle message = ResourceBundle.getBundle("messagesBundle", locale);
        String numberOfItemsMessage = message.getString("numberOfItemsMessage");
        String priceMessage = message.getString("priceMessage");
        String quantityMessage = message.getString("quantityMessage");
        String costMessage = message.getString("costMessage");

        // Calculate the total cost of each item (price × quantity).
        System.out.print(numberOfItemsMessage + " ");
        numberOfItems = scanner.nextInt();
        for (int i = 0; i < numberOfItems; i++) {
            System.out.print(priceMessage + " ");
            int hinta = scanner.nextInt();
            System.out.print(quantityMessage + " ");
            int maara = scanner.nextInt();

            totalPrice += hinta * maara;
        }
        System.out.print(costMessage + ": " + totalPrice);
        scanner.close();


    }
}
