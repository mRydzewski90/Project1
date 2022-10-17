package utilities;

import app.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeProductOrAmountInCloneList {

    public void addList() throws FileNotFoundException {
        ShowList.listFile(new File("ShoppingList//"));
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

//        System.out.println("witch indeks do you want change");
//        int indeks = app.Main.scanner.nextInt();
//        String product = (String) list.get(indeks - 1);
//        System.out.println("Write correct product");
//        product = app.Main.scanner.nextLine();
//        System.out.println(list);
    }
}