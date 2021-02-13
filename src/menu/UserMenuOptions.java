package menu;

public class UserMenuOptions {

    public static void mainMenu(){
        System.out.println("");
        System.out.println("Press 1 for adding a book to the library.");
        System.out.println("Press 2 for writing a review for a book.");
        System.out.println("Press 3 to edit a book, but please note you must be the owner");
        System.out.println("Press 4 to go to favorites");
        System.out.println("Press 5 to rate a book.");
        System.out.println("Press 6 to list all public books.");
        System.out.println("Press 0 to exit the library.");
        System.out.println("");
    }

    public static void favoritesMenu(){
        System.out.println("");
        System.out.println("Press 0 to go back to the main menu.");
        System.out.println("Press 1 to list all books");
        System.out.println("Press 2 to add a book.");
        System.out.println("Press 3 to remove a book.");
        System.out.println("");
    }

    public static void editMenu(){
        System.out.println("");
        System.out.println("Press 0 to go back to the main menu.");
        System.out.println("Press 1 to edit the author.");
        System.out.println("Press 2 to edit the resume.");
        System.out.println("");
    }

}
