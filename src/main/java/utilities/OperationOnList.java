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

    public void LoadYourLastList() throws IOException {
        String filePath = "ImportantFile//lastListName.txt";
        String listName = "";
        BufferedReader fileReader = null;

        try{
            fileReader = new BufferedReader(new FileReader(filePath));
            listName = fileReader.readLine();
        } finally {
            if (fileReader !=null){
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
}