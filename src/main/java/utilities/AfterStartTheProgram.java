package utilities;

import java.io.File;

public class AfterStartTheProgram {
    public void createFolders() {
        new File("ShoppingList").mkdir();
        new File("ImportantFile").mkdir();
    }
}

