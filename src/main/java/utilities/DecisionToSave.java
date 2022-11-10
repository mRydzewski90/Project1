package utilities;

import app.Main;

import java.io.IOException;
import java.util.ArrayList;

public class DecisionToSave {

    public boolean saveToFile(ArrayList<ItemsAndFilePaths.ShoppingListItems> shoppingList) throws IOException {
        String input;

        do {
            System.out.println("\nDo you want to save the created list? 'yes' or 'no', choose correct option");
            input = Main.scanner.next().toLowerCase();

        } while (!input.equals("yes") && !input.equals("no"));

        if (input.equals("yes")) {
            OperationOnList operationofList = new OperationOnList();
            operationofList.saveList(shoppingList);
        } else {
            System.out.println("list has not been saved");
        }
        return false;
    }
}