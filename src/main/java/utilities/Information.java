package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Information {

    public void loadInformation() throws IOException {

        File helpInformation = new File("src//main//resources//ImportantFile//Help.txt");
        Scanner myReader = new Scanner(helpInformation);

        while (myReader.hasNext())
            System.out.println(myReader.nextLine());
        myReader.close();
    }
}