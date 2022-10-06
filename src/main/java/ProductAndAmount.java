public class ProductAndAmount {
    private String product;
    private int amount;

    public ProductAndAmount(String product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getProduct() {
        return this.product;
    }
}