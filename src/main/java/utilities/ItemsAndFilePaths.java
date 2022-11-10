package utilities;

public class ItemsAndFilePaths {

// Name of files and paths files

    private String listName;
    private String savedListsFilePath = "ShoppingList//" + listName + ".txt";

    public String getName() {
        return listName;
    }
    public void setName(String listName) {
        this.listName = listName;
    }

    public String getSavedListsFilePath() {
        return savedListsFilePath;
    }

    public void setSavedListsFilePath(String newSavedListFilePath) {
        this.savedListsFilePath = newSavedListFilePath;
    }

// Shopping list items

    public static class ShoppingListItems {

        private String product;
        private int amount;

        public ShoppingListItems(String product, int amount) {
            this.product = product;
            this.amount = amount;
        }

        public int getAmount() {
            return this.amount;
        }

        public String getProduct() {
            return this.product;
        }

        public String toString() {
            return "Product: " + product + " amount: " + amount;
        }
    }
}