package manage_input;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import utils.ConstantValues;

public class NameAndPassword {

    private String name;
    private String password;

    public boolean validateInput(String name) {
        return name.length() < 4 || name.length() > 8 || !Pattern.matches("[a-zA-Z0-9]+", name);
    }

    public static boolean validatePassword(String user, String password) throws IOException {
        BufferedReader bufferreader =
                new BufferedReader(new FileReader(ConstantValues.dirUsers.toString()+String.format("\\%s.txt", user)));
        return bufferreader.readLine().equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName() {
        //Read user name and check if it is valid, if not, reread.
        while (true) {
            System.out.println("Please enter user name:");
            String a = ConstantValues.sc.nextLine().toLowerCase();
            if (validateInput(a)) {
                System.out.println("User name should be between 4-8 symbols long, having letters or numbers only.");
            } else {
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
        while (true) {
            System.out.println("Please enter password:");
            String b = ConstantValues.sc.nextLine();
            if (validateInput(b)) {
                System.out.println("Password should be between 4-8 symbols long, having letters or numbers only.");
            } else {
                this.password = b;
                break;
            }
        }
    }
}
