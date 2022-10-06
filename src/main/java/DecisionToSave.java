import java.io.IOException;
import java.util.ArrayList;

public class DecisionToSave {

    public boolean saveToFile(ArrayList<ProductAndAmount> shoppingList) throws IOException {
        String inPut;

        do {
            System.out.println("\nDo you want to save the created list? 'yes' or 'no', choose correct option");
            inPut = Main.scanner.next().toLowerCase();

        } while (!inPut.equals("yes") && !inPut.equals("no"));

        if (inPut.equals("yes")) {
            Save save = new Save();
            save.saveList(shoppingList);
        } else {
            System.out.println("list has not been saved");
        }
        return false;
    }
}

