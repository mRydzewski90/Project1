package utilities;

import app.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationOnList {

    private String name;   // modyfikator dostępu

    public void saveList(ArrayList<ProductAndAmount> shoppingList) throws IOException {

        System.out.println("Enter a file name:");
        name = Main.scanner.next();
        FileWriter saveFile = new FileWriter("ShoppingList//" + name + ".txt");
        saveFile.write(String.valueOf(shoppingList));
        saveFile.close();
        File s = new File("ShoppingList//" + name + ".txt");

        if (s.exists()) {
            System.out.println("Your list has been saved");
            FileWriter saveName = new FileWriter("ImportantFile//lastListName.txt");
            saveName.write(name);
            saveName.close();
        } else {
            System.out.println("Houston, we have a problem");
        }
    }

    public void loadYourLastList() throws IOException {
        String filePath = "ImportantFile//lastListName.txt";
        String listName = "";
        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            listName = fileReader.readLine();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        File lastList = new File("ShoppingList//" + listName + ".txt");

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
        listFile(new File("ShoppingList//"));
        System.out.println("witch list do you want to change");
        String name = Main.scanner.nextLine();
        Scanner scan = new Scanner(new File("ShoppingList//List_" + name + ".txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String element = scan.nextLine();
            list.add(element);
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    public void deleteFileWithList() {
        listFile(new File("ShoppingList//"));
        System.out.println("Which list you want to delete, choose correct number");
        String nameList = Main.scanner.next();
        File deleteFile = new File("ShoppingList//List_" + nameList + ".txt");

        if (!deleteFile.exists()) {
            System.out.println("First you need to create a file to be able to delete it");
        } else {
            System.out.println("do you want to delete the recently added file? 'yes' or 'no'");
            String input = Main.scanner.nextLine();

            if (input.equals("yes")) {
                deleteFile.delete();

                if (deleteFile.exists()) {
                    System.out.println("Houston, we have a problem");
                } else {
                    System.out.println("the file has been deleted ");
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
}
