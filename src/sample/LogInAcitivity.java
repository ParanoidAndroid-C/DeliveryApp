package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LogInAcitivity {
    String address;
    public boolean logInSuc(String username, String password) {
        try {
            Scanner myReader = new Scanner( new File("data.txt"));
            int linenum = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(username) && linenum % 3 == 0) {
                    if (myReader.nextLine().equals(password)) {
                        address = myReader.nextLine();
                        return true;
                    }
                }
                linenum ++;
            }
            myReader.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    public String getAdress() {
        return address;
    }


}
