import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProductManager {
    HashMap<String, Product> products;

    CategoryManager categoryManager = new CategoryManager();

    public ProductManager() {
        products = new HashMap<String, Product>();
    }

    // add product
    public void addProduct(Scanner scanner) {
        System.out.println("Please enter product name: ");
        String productName = scanner.nextLine();

        System.out.println("Please enter product category:");
        String productCategory = scanner.nextLine();
        if (categoryManager.checkIfCategoryExists(productCategory)) {
            System.out.println("ada existing category");
        } else {
            Category category = new Category(productCategory);
            categoryManager.add(category);
            System.out.println("buat category baru");
        }
    }


    // display all product created
    public void displayAllProduct() {
        if (!products.isEmpty()) {
            for (Product product : products.values()) {
                System.out.println("Product name: " + product.getName());
                System.out.println("Product Id: " + product.getProductId());
                System.out.println("Product category: " + product.getCategory());
                System.out.println("Product price: " + product.getPrice());
                System.out.println("Product quantity: " + product.getQuantity());

            }
        }
    }

}
