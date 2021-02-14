package manage.input;


import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import utils.ConsoleOperations;
import utils.ConstantValues;

public class NameAndPassword {

    private String name;
    private String password;

    public boolean validateInput(String name) {
        return name.length() < 4 || name.length() > 8 || !Pattern.matches("[a-zA-Z0-9]+", name);
    }

    public static boolean validatePassword(String user, String password) throws IOException {
        BufferedReader bufferreader =
                new BufferedReader(new FileReader(ConstantValues.DIR_USERS.toString() + String.format("\\%s.txt", user)));
        return bufferreader.readLine().equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName() {
        //Read user name and check if it is valid, if not, reread.
        while (true) {
            System.out.print("Please enter user name: ");
            String a = ConstantValues.SC.nextLine().toLowerCase();
            if (validateInput(a)) {
                System.out.println("User name should be between 4-8 symbols long, having letters or numbers only.");
            } else {
                ConsoleOperations.clearConsole();
                this.name = a;
                break;
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        //Read password and check if it is valid, if not, reread.

        byte count = 4;
        while (true) {
            System.out.print("Please enter password: ");
            String b = new String(System.console().readPassword());
            if (validateInput(b)) {
                count--;
                System.out.println("Password should be between 4-8 symbols long, having letters or numbers only.");
                System.out.println("" + count + " retries left.");
                if (count == 0) {
                    System.out.println("Please try again later.");
                    System.exit(0);
                }
            } else {
                ConsoleOperations.clearConsole();
                this.password = b;
                break;
            }
        }
    }
}
