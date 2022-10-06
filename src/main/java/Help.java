public class Help {
    private String Help = "\nCreate: Create new shopping list.\n" +
            "Last: Your last shopping list.\n" +
            "Change: You can clone your saved list and change products.\n" +
            "Delete: Delete saved list.\n" +
            "Exit: Close the program";

    public void printHelp() {
        System.out.println(Help);
    }
}
