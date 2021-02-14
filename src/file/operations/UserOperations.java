package file.operations;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

import utils.ConstantValues;

public class UserOperations {

    public static void createUserFile(String user, String pass) throws IOException {

        if (!ConstantValues.DIR_USERS.exists()) {
            ConstantValues.DIR_USERS.mkdirs();
        }

        File tmp = new File(ConstantValues.DIR_USERS, String.format("%s.txt", user));
        if (!tmp.exists()) {
            tmp.createNewFile();
            FileWriter myWriter = new FileWriter(tmp.getPath());
            myWriter.write(pass);
            myWriter.close();
            System.out.printf("Hi %s, you are now a member of the Book library.%n", user);
        }

    }

    public static boolean userExists(String user) {
        if (ConstantValues.DIR_USERS.list() == null) {
            return false;
        } else {
            return Arrays.asList(Objects.requireNonNull(ConstantValues.DIR_USERS.list())).contains(String.format("%s.txt", user));
        }
    }

}
