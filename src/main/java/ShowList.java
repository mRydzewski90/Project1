import java.io.File;

public class ShowList {

    private static String sep = "";


    public static void listFile(File file) {
        ShowList.sep += ".";
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            for (int i = 0; i < fileList.length; i++) {
                ShowList.listFile(fileList[i]);
            }
        } else {
            System.out.println(ShowList.sep + file.getName());
        }
        ShowList.sep = ShowList.sep.substring(0, ShowList.sep.lastIndexOf('.'));
    }
}