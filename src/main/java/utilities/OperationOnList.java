package utilities;

import app.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationOnList {

    // private String name;   // modyfikator dostępu
    private static final String SHOPPING_LIST_DIR = "ShoppingList//";
    //todo
    ItemsAndFilePaths items;

    public void saveList(ArrayList<ItemsAndFilePaths.ShoppingListItems> shoppingList) throws IOException {
        System.out.println("Enter a file name:");
        ItemsAndFilePaths items = new ItemsAndFilePaths(Main.scanner.next());

        FileWriter saveFile = new FileWriter(items.getSavedListsFilePath());
        saveFile.write(String.valueOf(shoppingList));
        saveFile.close();

        File lastNameOfList = new File(items.getSavedListsFilePath());

        if (lastNameOfList.exists()) {
            System.out.println("Your list has been saved");
            saveFile = new FileWriter("src//main//resources//ImportantFile//lastListName.txt");
            saveFile.write(items.getName());
            saveFile.close();
        } else {
            System.out.println("Something went wrong, the file was not saved");
        }
    }

    public void loadYourLastList() throws IOException {
        BufferedReader fileReader = null;
        String lastListName = "";
        ItemsAndFilePaths getPath = new ItemsAndFilePaths();

        try {
            fileReader = new BufferedReader(new FileReader(getPath.getSavedListsFilePath()));
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

    public void deleteFileWithList() {

        listFile(new File(SHOPPING_LIST_DIR));
        System.out.println("Which list you want to delete? Choose correct number");
        String listToBeDeleted = Main.scanner.nextLine();
        File deleteFile = new File(SHOPPING_LIST_DIR + listToBeDeleted + ".txt");

        if (!deleteFile.exists()) {
            System.out.println("First you need to create a file to be able to delete it");
        } else {
            System.out.println("Do you want to delete the recently added file? 'yes' or 'no'");
            listToBeDeleted = Main.scanner.nextLine();

            if (listToBeDeleted.equals("yes")) {
                deleteFile.delete();

                if (deleteFile.exists()) {
                    System.out.println("Houston, we have a problem");
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
