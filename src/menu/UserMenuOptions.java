package menu;

import utils.ConsoleOperations;
import utils.ConstantValues;

import java.util.regex.Pattern;

public class UserMenuOptions {

    public static byte mainMenu() {

        ConsoleOperations.clearConsole();
        System.out.println("");
        System.out.println("You are now in the Main menu.");
        System.out.println("");
        System.out.println("Press 1 to add a book.");
        System.out.println("Press 2 to read/write reviews.");
        System.out.println("Press 3 to edit a book.");
        System.out.println("Press 4 to go to favorites.");
        System.out.println("Press 5 to go to your personal library");
        System.out.println("Press 6 to rate a book.");
        System.out.println("Press 7 to list all public books.");
        System.out.println("Press 0 to exit the library.");
        System.out.println("");

        return validateMenuInput((byte) 0, (byte) 7);
    }

    public static byte favoritesMenu() {

        ConsoleOperations.clearConsole();
        System.out.println("");
        System.out.println("You are now in the favorites menu.");
        System.out.println("");
        System.out.println("Press 1 to list all books");
        System.out.println("Press 2 to add a book.");
        System.out.println("Press 3 to remove a book.");
        System.out.println("Press 0 to go back to the main menu.");
        System.out.println("");

        return validateMenuInput((byte) 0, (byte) 3);
    }

    public static byte editMenu() {

        ConsoleOperations.clearConsole();
        System.out.println("");
        System.out.println("You are now in the edit menu.");
        System.out.println("");
        System.out.println("Press 0 to go back to the main menu.");
        System.out.println("Press 1 to edit the author.");
        System.out.println("Press 2 to edit the resume.");
        System.out.println("");

        return validateMenuInput((byte) 0, (byte) 2);
    }

    public static byte personalMenu() {

        ConsoleOperations.clearConsole();
        System.out.println("");
        System.out.println("You are now in the personal library menu.");
        System.out.println("");
        System.out.println("Press 0 to go back to the main menu.");
        System.out.println("Press 1 to list all books in your personal library.");
        System.out.println("Press 2 to add a book to your personal library.");
        System.out.println("Press 3 to remove a book from your personal library.");
        System.out.println("");

        return validateMenuInput((byte) 0, (byte) 3);
    }

    public static byte reviewMenu() {

        ConsoleOperations.clearConsole();
        System.out.println("");
        System.out.println("You are now in the read/write reviews menu.");
        System.out.println("");
        System.out.println("Press 0 to go back to the main menu.");
        System.out.println("Press 1 to read reviews for a book.");
        System.out.println("Press 2 to write a review for a book.");
        System.out.println("");

        return validateMenuInput((byte) 0, (byte) 2);

    }

    public static byte logInMenu() {

        System.out.println("\nWelcome to the Book Library! \n");
        System.out.println("Press 1 to log in.");
        System.out.println("Press 2 to sign up.");
        System.out.println("Press 0 to Exit.");
        System.out.println("");

        return validateMenuInput((byte) 0, (byte) 2);

    }


    private static byte validateMenuInput(byte min, byte max) {

        System.out.print("Please enter your choice: ");
        String input = "";

        while (true) {
            input = ConstantValues.SC.nextLine();
            if (!Pattern.matches(String.format("[%s-%s]", min, max), input)) {
                ConsoleOperations.clearConsole();
                System.out.printf("Invalid input! Please enter a number between %s and %s%n", min, max);
                System.out.println("Please enter your choice: ");
            } else {
                ConsoleOperations.clearConsole();
                return Byte.parseByte(input);
            }
        }
    }

    public static boolean wouldYouContinue(String user) {

        while (true) {
            System.out.print("\nWould you like to continue (yes/no): ");
            String input = ConstantValues.SC.nextLine();
            if (input.equalsIgnoreCase("yes")){
                return true;
            }
            else if (input.equalsIgnoreCase("no")){
                ConsoleOperations.clearConsole();
                System.out.println("\n Thank you for using the library, " + user + " :)");
                return false;
            }
            else {
                System.out.println("Invalid input, please write yes or no.");
            }
        }
    }
}
