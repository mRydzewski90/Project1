import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeProductOrAmountInCloneList {

    public void addList() throws FileNotFoundException {
        ShowList.listFile(new File("ShoppingList//"));
        System.out.println("witch list do you want to change");
        Save.number = Integer.parseInt(Main.scanner.nextLine());
        Scanner scan = new Scanner(new File("ShoppingList//List_" + Save.number + ".txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String element = scan.nextLine();
            list.add(element);
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

//        System.out.println("witch indeks do you want change");
//        int indeks = Main.scanner.nextInt();
//        String product = (String) list.get(indeks - 1);
//        System.out.println("Write correct product");
//        product = Main.scanner.nextLine();
//        System.out.println(list);
    }
}