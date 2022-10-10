import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class LoadLastSavedList {
    String filePath = "LastListName//lastListName.txt";
    String listName = "";
    BufferedReader fileReader = null;

    public void yourLastList() throws IOException {
        try{
            fileReader = new BufferedReader(new FileReader(filePath));
            listName = fileReader.readLine();
        } finally {
            if (fileReader !=null){
                fileReader.close();
            }
        }
        File lastList = new File("ShoppingList//" + listName + ".txt");

        if (lastList.exists()) {
            System.out.println("Your shopping list");
            Scanner myReader = new Scanner(lastList);

            while (myReader.hasNext())
                System.out.println(myReader.nextLine());
            myReader.close();
        } else {
            System.out.println("You don`t have any list yet");
        }
    }
}