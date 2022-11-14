package utilities;

import app.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationOnList {

    // private String name;   // modyfikator dostępu
    private static final String SHOPPING_LIST_DIR = "ShoppingList//";
    private static final String SHOPPING_LIST_NAME_DIR = "src//main//resources//ImportantFile//lastListName.txt";

    //todo

    public void saveList(List<ItemsAndFilePaths.ShoppingListItems> shoppingList) throws IOException {
        System.out.println("Enter a file name:");
        ItemsAndFilePaths items = new ItemsAndFilePaths(Main.scanner.next());

        FileWriter saveFile = new FileWriter(items.getSavedListsFilePath());
        saveFile.write(String.valueOf(shoppingList));
        saveFile.close();

        File lastNameOfList = new File(items.getSavedListsFilePath());

        if (lastNameOfList.exists()) {
            System.out.println("Your list has been saved");
            saveFile = new FileWriter(SHOPPING_LIST_NAME_DIR);
            saveFile.write(items.getName());
            saveFile.close();
        } else {
            System.out.println("Something went wrong, the file was not saved");
        }
    }

    public void loadYourLastList() throws IOException {
        BufferedReader fileReader = null;
        String lastListName = "";

        File listNameCatcher = new File(SHOPPING_LIST_NAME_DIR);
        if (listNameCatcher.exists())
            try {
                fileReader = new BufferedReader(new FileReader(SHOPPING_LIST_NAME_DIR));
                lastListName = fileReader.readLine();
            } finally {
                if (fileReader != null) {
                    fileReader.close();
                }
            }

        File lastList = new File(SHOPPING_LIST_DIR + lastListName + ".txt");

        if (lastList.exists()) {
            System.out.println("Your shopping list");
            Scanner myReader = new Scanner(lastList);

            while (myReader.hasNext())
                System.out.println(myReader.nextLine());
            myReader.close();
        } else {
            System.out.println("You don`t have any list yet");
        }
    }

    public void showList() throws FileNotFoundException {
        listFile(new File(SHOPPING_LIST_DIR));
        System.out.println("witch list do you want to change");
        String name = Main.scanner.nextLine();
        Scanner scan = new Scanner(new File(SHOPPING_LIST_DIR + name + ".txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String element = scan.nextLine();
            list.add(element);
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    public void deleteShoppingList() {
        System.out.println("Yours saved list:");
        listFile(new File(SHOPPING_LIST_DIR));
        System.out.println("\nWhich list you want to delete? Choose correct number");
        String listToBeDeleted = Main.scanner.next().toLowerCase();
        File deleteFile = new File(SHOPPING_LIST_DIR + listToBeDeleted + ".txt");

        if (!deleteFile.exists()) {
            System.out.println("First you need to create a file to be able to delete it");
        } else {
            System.out.println("Do you want to delete the recently added file? 'yes' or 'no'");
            listToBeDeleted = Main.scanner.next().toLowerCase();

            if (listToBeDeleted.equals("yes")) {
                deleteFile.delete();

                if (deleteFile.exists()) {
                    System.out.println("System has a problem, the file has not been deleted");
                } else {
                    System.out.println("The file has been deleted ");
                }
            }
        }
    }

    private static String sep = "";

    public static void listFile(File file) {
        sep += ".";
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            for (int i = 0; i < fileList.length; i++) {
                listFile(fileList[i]);
            }
        } else {
            System.out.println(sep + file.getName());
        }
        sep = sep.substring(0, sep.lastIndexOf('.'));
    }

    public void addItemsToList() throws IOException {
        ArrayList<ItemsAndFilePaths.ShoppingListItems> shoppingList = new ArrayList<>();
        boolean isRunning = true;
        System.out.println("'quit' to end creating and show your list");

        while (isRunning) {
            System.out.println("Add product: ");
            String product = Main.scanner.next().toLowerCase();
            if (!product.equalsIgnoreCase("quit")) {
                System.out.println("Add amount: ");
                int amount = Main.scanner.nextInt();
                ItemsAndFilePaths.ShoppingListItems all = new ItemsAndFilePaths.ShoppingListItems(product, amount);
                shoppingList.add(all);
            } else {
                System.out.println("Your shopping list ");
                for (ItemsAndFilePaths.ShoppingListItems t : shoppingList) {
                    System.out.println("Product: " + t.getProduct() + "\nAmount: " + t.getAmount());
                }
                DecisionToSave choice = new DecisionToSave();
                isRunning = choice.saveToFile(shoppingList);
            }
        }
    }
}