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
        String category = scanner.nextLine();
        Category productCategory = null;
        if (categoryManager.checkIfCategoryExists(category) != null) {
            productCategory = categoryManager.checkIfCategoryExists(category);
        } else {
            productCategory = new Category(category);
            categoryManager.add(productCategory);
        }

        float productPrice = 0;
        boolean isPriceOkay = false;
        while (!isPriceOkay) {
            System.out.println("Please enter product price: ");
            try {
                productPrice = Float.parseFloat(scanner.nextLine());
                isPriceOkay = true;
            } catch (NumberFormatException e) {
                System.out.println("Product price is not valid");
            }
        }

        int productQuantity = 0;
        boolean isQuantityOkay = false;
        while (!isQuantityOkay) {
            System.out.println("Please enter product quantity: ");
            try {
                productQuantity = Integer.parseInt(scanner.nextLine());
                isQuantityOkay = true;
            } catch (NumberFormatException e) {
                System.out.println("Product quantity is not valid");
            }
        }

        Product product = new Product(productName, productCategory, productPrice, productQuantity);
        products.put(product.getProductId(), product);

        System.out.println("\nProduct created");
        System.out.println("__________");
        displayProduct(product);
    }

    public void removeProductById(Scanner scanner) {
        System.out.println("Please enter product id: ");
        String productId = scanner.nextLine();

        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product with product id " + productId + " removed\n");
        } else {
            System.out.println("Cannot find product with that id\n");
        }
    }

    public void displayProduct(Product product) {
        System.out.println("Product name: " + product.getName());
        System.out.println("Product Id: " + product.getProductId());
        System.out.println("Product category: " + product.getCategory().getName());
        System.out.println("Product price: " + product.getPrice());
        System.out.println("Product quantity: " + product.getQuantity());
        System.out.println();
    }


    // display all product created
    public void displayAllProduct() {
        if (!products.isEmpty()) {
            for (Product product : products.values()) {
                System.out.println("Product name: " + product.getName());
                System.out.println("Product Id: " + product.getProductId());
                System.out.println("Product category: " + product.getCategory().getName());
                System.out.println("Product price: " + product.getPrice());
                System.out.println("Product quantity: " + product.getQuantity());
                System.out.println();
            }
        } else {
            System.out.println("There is no product available, please add one\n");
        }
    }

}
