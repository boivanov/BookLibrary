import NameAndPassword.*;

import java.io.File;

public class Demo {
    public static void main(String[] args) {

       NameAndPassword userPass = new NameAndPassword();
       userPass.setName();
       userPass.setPassword();

       System.out.println(userPass.getName() + "  " + userPass.getPassword());

       File a = new File("asd");

       System.out.println(a.getAbsolutePath());
    }
}
