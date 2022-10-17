package app;

import utilities.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        AfterStartTheProgram folders = new AfterStartTheProgram();
        folders.createFolder();
        System.out.println("Welcome in Shopping List Application\n");
        String option;

        do {
            System.out.println("\nYou can choose this options : Help, Create, Last, Change, Delete, Exit");
            option = scanner.next().toLowerCase();

            switch (option) {
                case "help":
                    Information printInstruction = new Information();
                    printInstruction.loadInformation();
                    break;
                case "create":
                    AddProductAndAmount list = new AddProductAndAmount();
                    list.addProductAndAmount();
                    break;
                case "last":
                    OperationOnList load = new OperationOnList();
                    load.loadYourLastList();
                    break;
                case "delete":
                    OperationOnList deleteList = new OperationOnList();
                    deleteList.deleteFileWithList();
                    break;
                case "change":
                    OperationOnList change = new OperationOnList();
                    change.showList();
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




