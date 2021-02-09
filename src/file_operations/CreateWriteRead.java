package file_operations;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import utils.ConstantValues;

public class CreateWriteRead {

    public static void CreateUserFile(String user, String pass) throws IOException {

        if(!ConstantValues.dirUsers.exists()) {
            ConstantValues.dirUsers.mkdirs();
        }

        File tmp = new File(ConstantValues.dirUsers, String.format("%s.txt", user));
        if(!tmp.exists()) {
            tmp.createNewFile();
            FileWriter myWriter = new FileWriter(tmp.getPath());
            myWriter.write(pass);
            myWriter.close();
            System.out.printf("Hi %s, you are now a member of the book_info.Book library.%n", user);
        }

    }

    public static String GetExistingUserPassword(String user) throws IOException {
        BufferedReader bufferreader =
                new BufferedReader(new FileReader(ConstantValues.dirUsers.toString()+String.format("\\%s.txt", user)));
        return bufferreader.readLine();
    }

    public static boolean userExists(String user) {
        return Arrays.asList(Objects.requireNonNull(ConstantValues.dirUsers.list())).contains(String.format("%s.txt", user));
    }

}
