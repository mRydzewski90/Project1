import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {

    static int number;
    static String name;

    public void saveList(ArrayList<ProductAndAmount> shoppingList) throws IOException {
        new File("ShoppingList").mkdir();
        new File("LastListName").mkdir();
        System.out.println("Enter a file name:");
        name = Main.scanner.next();
        FileWriter saveFile = new FileWriter("ShoppingList//" + name + ".txt");
        saveFile.write(String.valueOf(shoppingList));
        saveFile.close();
        File s = new File("ShoppingList//" + name + ".txt");
        if (s.exists()) {
            System.out.println("Your list has been saved");
            FileWriter saveName = new FileWriter("LastListName//lastListName.txt");
            saveName.write(name);
            saveName.close();
        } else {
            System.out.println("Houston, we have a problem");
        }
    }
}