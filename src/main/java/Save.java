import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {

    static int number;

    public void saveList(ArrayList<ProductAndAmount> shoppingList) throws IOException {
        new File("ShoppingList").mkdir();
        File actually = new File("ShoppingList//List_" + number + ".txt");

        while (actually.exists()) {
            number++;
            actually = new File("ShoppingList//List_" + number + ".txt");
        }
        FileWriter saveFile = new FileWriter("ShoppingList//List_" + number + ".txt");
        saveFile.write(String.valueOf(shoppingList));
        saveFile.close();
        File s = new File("ShoppingList//List_" + number + ".txt");
        if (s.exists()) {
            System.out.println("Your list has been saved");
        } else {
            System.out.println("Houston, we have a problem");
        }
    }
}