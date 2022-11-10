package utilities;

import java.io.File;

public class AfterStartTheProgram {
    public static void createFolder() {
        new File("ShoppingList").mkdir();
    }
}