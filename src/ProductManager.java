import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProductManager {
    HashMap<String, Product> products;
    ArrayList<Product> purchasedProducts;

    CategoryManager categoryManager;

    public ProductManager() {
        products = new HashMap<String, Product>();
        purchasedProducts = new ArrayList<>();
        categoryManager = new CategoryManager();
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
        if (!products.isEmpty()) {
            Product removedProduct = findProductById(scanner);
            if (removedProduct != null) {
                products.remove(removedProduct.getProductId());
                System.out.println("Product removed\n");
            }
        } else {
            System.out.println("There is no product available, please add one\n");
        }
    }

    public void updateProduct(Scanner scanner) {
        Product foundProduct = findProductById(scanner);

        int choice = 0;
        boolean isChoiceOkay = false;
        while (!isChoiceOkay) {
            System.out.println("Update (1.Price, 2.Quantity, 3.Category) :");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                isChoiceOkay = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice\n");
            }
        }

        switch (choice) {
            case 1:
                float price = 0;
                boolean isPriceOkay = false;
                while (!isPriceOkay) {
                    System.out.println("Update product price from RM" + foundProduct.getPrice() + " to :");
                    try {
                        price = Float.parseFloat(scanner.nextLine());
                        isPriceOkay = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price");
                    }
                }
                foundProduct.setPrice(price);
                System.out.println("Price updated to RM" + foundProduct.getPrice() + "\n");
                break;
            case 2:
                int quantity = 0;
                boolean isQuantityOkay = false;
                while (!isQuantityOkay) {
                    System.out.println("Update quantity from " + foundProduct.getQuantity() + " to :");
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                        isQuantityOkay = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity");
                    }
                }
                foundProduct.setQuantity(quantity);
                System.out.println("Quantity updated to " + foundProduct.getQuantity() + "\n");
                break;
            case 3:
                System.out.println("Update category from " + foundProduct.getCategory().getName() + " to :");
                String category = scanner.nextLine();
                Category productCategory = null;
                if (categoryManager.checkIfCategoryExists(category) != null) {
                    productCategory = categoryManager.checkIfCategoryExists(category);
                } else {
                    productCategory = new Category(category);
                    categoryManager.add(productCategory);
                }
                foundProduct.setCategory(productCategory);
                System.out.println("Category updated to " + foundProduct.getCategory().getName() + "\n");
        }

    }

    public Product findProductById(Scanner scanner) {
        System.out.println("Please enter product id");
        String productId = scanner.nextLine();

        if (products.containsKey(productId)) {
            return products.get(productId);
        } else {
            System.out.println("Cannot find product with that id\n");
        }

        return null;
    }

    public void displayFoundProduct(Scanner scanner) {
        int choice = 0;
        boolean isChoiceOkay = false;
        while (!isChoiceOkay) {
            System.out.println("Search by (1. Name, 2. Category)");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                isChoiceOkay = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please try again");
            }
        }

        switch (choice) {
            case 1:
                Product foundProduct = findProductByName(scanner);
                if (foundProduct != null) {
                    System.out.println("\nFound product");
                    System.out.println("__________");
                    displayProduct(foundProduct);
                }
                break;
            case 2:
                ArrayList<Product> foundProducts = findProductByCategory(scanner);
                if (!foundProducts.isEmpty()) {
                    System.out.println("\nFound product");
                    System.out.println("__________");
                    for (Product product : foundProducts) {
                        displayProduct(product);
                    }
                } else {
                    System.out.println("Cannot find product with that category\n");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void productAvailability(Scanner scanner) {
        Product foundProduct = findProductByName(scanner);
        if (foundProduct != null) {
            if (foundProduct.getQuantity() == 0) {
                System.out.println("Product is out of stock\n");
            } else {
                System.out.println("Product is in stock\n");
            }
        } else {
            System.out.println("Product with that name is not found");
        }
    }

    public void totalInventory() {
        float totalPrice = 0;
        int totalQuantity = 0;

        for (Product product : products.values()) {
            totalPrice += product.getPrice();
            totalQuantity += product.getQuantity();
        }

        System.out.println("Total inventory value: RM" + (totalPrice * totalQuantity) + "\n");
    }

    public Product findProductByName(Scanner scanner) {
        System.out.println("Please enter product name: ");
        String productName = scanner.nextLine();

        for (Product product : products.values()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }

        System.out.println("Cannot find product with that name\n");
        return null;
    }

    public ArrayList<Product> findProductByCategory(Scanner scanner) {
        System.out.println("Please enter product category: ");
        String productCategory = scanner.nextLine();

        ArrayList<Product> foundProducts = new ArrayList<>();

        for (Product product : products.values()) {
            if (product.getCategory().getName().equalsIgnoreCase(productCategory)) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    public void displayProduct(Product product) {
        System.out.println("Product name: " + product.getName());
        System.out.println("Product Id: " + product.getProductId());
        System.out.println("Product category: " + product.getCategory().getName());
        System.out.println("Product price: RM" + product.getPrice());
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
                System.out.println("Product price: RM" + product.getPrice());
                System.out.println("Product quantity: " + product.getQuantity());
                System.out.println();
            }
        } else {
            System.out.println("There is no product available, please add one\n");
        }
    }

}
