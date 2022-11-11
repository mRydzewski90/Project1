package utilities;

public class ItemsAndFilePaths {

// Saved list name

    private String savedListsFilePath;
    private String listName;


    public ItemsAndFilePaths(String listName) {
        this.listName = listName;
        savedListsFilePath = "ShoppingList//" + listName + ".txt";
    }

    public String getName() {
        return listName;
    }

    public void setName(String listName) {
        this.listName = listName;
    }

    public String getSavedListsFilePath() {
        return savedListsFilePath;
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