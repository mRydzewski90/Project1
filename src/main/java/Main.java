import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome in Shopping List Application\n");
        boolean flag = true;
        String option;

        while (flag) {
            System.out.println("\nYou can choose this options : Help, Create, Last, Change, Delete, Exit");
            option = scanner.next().toLowerCase();

            switch (option) {
                case "help":
                    Help printInstruction = new Help();
                    printInstruction.printHelp();
                    break;
                case "create":
                    AddProductAndAmount list = new AddProductAndAmount();
                    list.addProductAndAmount();
                    break;
                case "last":
                    LoadLastSavedList load = new LoadLastSavedList();
                    load.yourLastList();
                    break;
                case "delete":
                    DeleteList deleteList = new DeleteList();
                    deleteList.deleteFileWithList();
                    break;
                case "change":
                    ChangeProductOrAmountInCloneList change = new ChangeProductOrAmountInCloneList();
                    change.addList();
                    break;
                case "exit":
                    flag = false;
                    System.out.println("See you later!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose correct option");
                    break;
            }
        }
    }
}