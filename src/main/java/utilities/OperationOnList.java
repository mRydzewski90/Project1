package utilities;

import app.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OperationOnList {

    private static final String SHOPPING_LIST_DIR = "ShoppingList//";
    private static final File SHOPPING_LIST_NAME_DIR = new File("src//main//resources//ImportantFile//lastListName.txt");

    //todo

    public void saveShoppingList(List<ItemsAndFilePaths.ShoppingListItems> shoppingList) throws IOException {
        System.out.println("Enter a file name:");
        ItemsAndFilePaths items = new ItemsAndFilePaths(Main.scanner.next());
        FileWriter saveFile = new FileWriter(items.getSavedListsFilePath());
        saveFile.write(formatShoppingList(shoppingList));
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

    private String formatShoppingList(List<ItemsAndFilePaths.ShoppingListItems> shoppingList) {
        StringBuilder sb = new StringBuilder();
        for (ItemsAndFilePaths.ShoppingListItems shoppingListItems : shoppingList) {
            sb.append(shoppingListItems.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void loadLastShoppingList() throws IOException {
        BufferedReader fileReader = null;
        String lastListName = "";

        if (SHOPPING_LIST_NAME_DIR.exists()) {
            fileReader = new BufferedReader(new FileReader(SHOPPING_LIST_NAME_DIR));
            lastListName = fileReader.readLine();
            fileReader.close();
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

    // TODO: 22.11.2022  
    public void changeProductInShoppingList() throws FileNotFoundException {
        ItemsAndFilePaths.ShoppingListItems listItems = new ItemsAndFilePaths.ShoppingListItems();
        System.out.println("Your saved shopping list");
        listFile();
        System.out.println("\nWitch list do you want to change?");
        ItemsAndFilePaths items = new ItemsAndFilePaths(Main.scanner.next());
        File readFile = new File(items.getSavedListsFilePath());

        if (readFile.exists()) {
            System.out.println("Witch product do you want to change?\n");
            System.out.println("List name: " + items.getName());
            Scanner myReader = new Scanner(readFile);
            String[] array = new String[]{myReader.nextLine()};
            while (myReader.hasNext())
                
            myReader.close();
        } else {
            System.out.println("You don`t have any list yet");
        }

    }

    public void deleteShoppingList() {
        System.out.println("Yours saved list:");
        listFile();
        System.out.println("\nWhich list you want to delete? Write correct list name");
        String listToBeDeleted = Main.scanner.next().toLowerCase();
        File deleteFile = new File(SHOPPING_LIST_DIR + listToBeDeleted + ".txt");

        if (!deleteFile.exists()) {
            System.out.println("First you need to create a file to be able to delete it");
        } else {
            System.out.println("Do you want to delete the recently added file? 'yes' or 'no'");
            listToBeDeleted = Main.scanner.next().toLowerCase();

            if (listToBeDeleted.equals("yes")) {

                if (deleteFile.delete()) {
                    System.out.println("The file has been deleted ");
                } else {
                    System.out.println("System has a problem, the file has not been deleted");
                }
            }
        }
    }

    public static void listFile() {
        File shoppingListDir = new File(SHOPPING_LIST_DIR);
        File[] fileList = shoppingListDir.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No saved list found");
        }
    }

    public void createShoppingList() throws IOException {
        ArrayList<ItemsAndFilePaths.ShoppingListItems> shoppingList = new ArrayList<>();
        boolean isRunning = true;
        System.out.println("Write 'quit' to end creating and show your list");

        while (isRunning) {
            System.out.println("Add product: ");
            String product = Main.scanner.next().toLowerCase();

            if (!product.equalsIgnoreCase("quit")) {
                System.out.println("Add amount: ");
                int amount = Main.scanner.nextInt();
                ItemsAndFilePaths.ShoppingListItems all = new ItemsAndFilePaths.ShoppingListItems(product, amount);
                shoppingList.add(all);
            } else {
                System.out.println("Your shopping list");
                for (ItemsAndFilePaths.ShoppingListItems t : shoppingList) {
                    System.out.println(t.toString());
                }
                DecisionToSave choice = new DecisionToSave();
                isRunning = choice.saveToFile(shoppingList);
            }
        }
    }
}