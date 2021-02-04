package sample;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegisterActivity  {

    public boolean signUp(String username, String password, String address) throws IOException {
            if (!checkUsername(username))  {
                return false;
            }
            else {
                FileWriter myWriter = new FileWriter("data.txt", true);
                myWriter.append(username);
                myWriter.append('\n');
                myWriter.append(password);
                myWriter.append('\n');
                myWriter.append(address);
                myWriter.append('\n');
                myWriter.close();
                return true;
            }
    }

    private boolean checkUsername(String username) throws FileNotFoundException {
        File myObj = new File("data.txt");
        Scanner myReader = new Scanner(myObj);
        int linecnt = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (data.equals(username) && linecnt%3 == 0 ) {
                //System.out.println(myReader.nextLine());
                return false;
            }
            linecnt++;
        }
        myReader.close();
        return true;
    }


}
