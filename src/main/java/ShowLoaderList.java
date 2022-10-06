import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShowLoaderList {

    public void yourSavedList() throws FileNotFoundException {
        System.out.println("which list would you like to see?");
        File lastfile = new File("ShoppingList//List_" + Save.number + ".txt");
        Save.number = Integer.parseInt(Main.scanner.nextLine());
        if (lastfile.exists()) {
            System.out.println("Your shopping list");
            Scanner myReader = new Scanner(lastfile);
            while (myReader.hasNext())
                System.out.println(myReader.nextLine());
            myReader.close();
        } else {
            System.out.println("You don`t have any list yet");
        }
    }
}