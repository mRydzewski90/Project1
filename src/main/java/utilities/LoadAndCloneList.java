package utilities;

import app.Main;

import java.io.File;
import java.io.FileNotFoundException;

public class LoadAndCloneList {
//todo
    public void change() throws FileNotFoundException {
        boolean flag = true;
        while (flag) {
            String choose;
            String clone;
            System.out.println("Which list would you like to clone or if you want you can show saved list beafore clone" + "\n Write 'Show' or 'Clone'" + "\nif ypu wanna quite write 'Exit'");
            choose = Main.scanner.nextLine().toLowerCase();

            if (choose.equals("show")) {
                System.out.println("Your Saved Lists");
                OperationOnList.listFile(new File("ShoppingList//"));
                ShowLoaderList a = new ShowLoaderList();
                a.yourSavedList();

            } else if (choose.equals("clone")) {
                OperationOnList.listFile(new File("ShoppingList//"));
                System.out.println("Which list would you like to clone");
                ShowLoaderList a = new ShowLoaderList();
                a.yourSavedList();

            } else if (choose.equals("exit")) {
                flag = false;
            }
        }
    }
}