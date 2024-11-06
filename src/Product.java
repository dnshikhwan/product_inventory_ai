import java.util.UUID;

public class Product {
    private final String name;
    private final String productId;
    private Category category;
    private float price;
    private int quantity;

    public Product(String name, Category category, float price, int quantity) {
        this.name = name;
        this.productId = UUID.randomUUID().toString();
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public Category getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // setters
    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
