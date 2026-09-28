import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] consoleTypes = {"PS5", "XBOX", "SWITCH"};

        // Menu
        System.out.println("Select the console type");
        for (int i = 0; i < consoleTypes.length; i++) {
            System.out.println((i + 1) + ") " + consoleTypes[i]);
        }
        System.out.println();

        // Read the choice (repeat until valid)
        int choice = 0;
        while (choice < 1 || choice > consoleTypes.length) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next(); // discard invalid input
            }
            if (choice < 1 || choice > consoleTypes.length) {
                System.out.println("Invalid choice. Enter 1, 2 or 3:");
                choice = 0;
            }
        }
        input.nextLine(); // clear the newline

        String consoleType = consoleTypes[choice - 1];

        // Store name
        System.out.print("Enter the store: ");
        String store = input.nextLine();

        // Total sales
        System.out.print("Enter the total sales of " + consoleType
                + " consoles for " + store + ":");
        int totalSales = input.nextInt();
        System.out.println();

        // Create the object and print the report
        ConsoleSales report = new ConsoleSales(consoleType, store, totalSales);
        report.printReport();

        input.close();
    }
}