package app;

import utilities.Information;
import utilities.OperationOnList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        new File("ShoppingList").mkdir();
        System.out.println("Welcome in Shopping List Application\n");
        String option;
        OperationOnList operation = new OperationOnList();


        do {
            System.out.println("\nYou can choose this options : Help, Create, Last, Change, Delete, Exit");
            option = scanner.next().toLowerCase();

            switch (option) {
                case "help":
                    Information printInstruction = new Information();
                    printInstruction.loadInformation();
                    break;
                case "create":
                    operation.createShoppingList();
                    break;
                case "last":
                    operation.loadLastShoppingList();
                    break;
                case "delete":
                    operation.deleteShoppingList();
                    break;
                case "change":
                    operation.changeProductInShoppingList();
                    break;
                default:
                    if (!option.equals("exit"))
                        System.out.println("Choose correct option");
                    break;
            }
        }
        while (!option.equals("exit"));
        System.out.println("See you later");
    }
}




