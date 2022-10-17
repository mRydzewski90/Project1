package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Information {

    public void loadInformation() throws IOException {

        File helpInfromation = new File("ImportantFile//Help.txt");
        Scanner myReader = new Scanner(helpInfromation);

        while (myReader.hasNext())
            System.out.println(myReader.nextLine());
        myReader.close();
    }
}
