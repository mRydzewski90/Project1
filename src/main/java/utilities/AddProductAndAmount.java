package utilities;

import app.Main;
import utilities.ProductAndAmount;

import java.io.IOException;
import java.util.ArrayList;

public class AddProductAndAmount {

    public void addProductAndAmount() throws IOException {
        ArrayList<ProductAndAmount> shoppingList = new ArrayList<>();
        boolean isRunning = true;
        System.out.println("'quit' to end creating and show your list");

        while (isRunning) {
            System.out.println("Add product: ");
            String product = Main.scanner.next().toLowerCase();
            if (!product.equalsIgnoreCase("quit")) {
                System.out.println("Add amount: ");
                int amount = Main.scanner.nextInt();
                ProductAndAmount all = new ProductAndAmount(product, amount);
                shoppingList.add(all);
            } else {
                System.out.println("Your shopping list ");
                for (ProductAndAmount t : shoppingList) {
                    System.out.println("Product: " + t.getProduct() + "\nAmount: " + t.getAmount());
                }
                DecisionToSave choice = new DecisionToSave();
                isRunning = choice.saveToFile(shoppingList);
            }
        }
    }
}