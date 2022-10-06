import java.io.File;

public class DeleteList {

    public void deleteFileWithList() {
        ShowList.listFile(new File("ShoppingList//"));
        System.out.println("Which list you want to delete, choose correct number");
        Save.number = Integer.parseInt(Main.scanner.next());
        Main.scanner.nextLine();
        File deleteFile = new File("ShoppingList//List_" + Save.number + ".txt");

        if (!deleteFile.exists()) {
            System.out.println("First you need to create a file to be able to delete it");
        } else {
            System.out.println("do you want to delete the recently added file? 'yes' or 'no'");
            String inPut = Main.scanner.nextLine();

            if (inPut.equals("yes")) {
                deleteFile.delete();

                if (deleteFile.exists()) {
                    System.out.println("Houston, we have a problem");
                } else {
                    System.out.println("the file has been deleted ");
                }
            }
        }
    }
}