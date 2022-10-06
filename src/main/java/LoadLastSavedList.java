import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadLastSavedList {

    public void yourLastList() throws FileNotFoundException {
        File lastfile = new File("ShoppingList//List_" + Save.number + ".txt");

        if (lastfile.exists()) {
            System.out.println("Your shopping list");
            Scanner myReader = new Scanner(lastfile);
            while (myReader.hasNext()) System.out.println(myReader.nextLine());
            myReader.close();
        } else {
            System.out.println("You don`t have any list yet");
        }
    }
}