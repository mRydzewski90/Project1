package utilities;

import java.io.File;

public class CreateFolderWithShoppingList {
    public static void createFolder() {
        new File("ShoppingList").mkdir();
    }
}