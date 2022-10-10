import java.io.File;

public class DeleteList {

    public void deleteFileWithList() {
        ShowList.listFile(new File("ShoppingList//"));
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
}