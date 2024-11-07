/*
1. Add new product [X]
2. Remove by product id [X]
3. Update product info [X]
4. View all products [X]
5. Search product by name or category [X]
6. Product recommendation []
7. Check product availability [X]
8. Inventory value calculation [X]
9. Product popularity analysis []
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductManager productManager = new ProductManager();

        boolean flag = true;
        while (flag) {
            int command = 0;
            try {
                printMenu();
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input\n");
            }

            switch (command) {
                case 1:
                    System.out.println("\nAdd new product");
                    System.out.println("_____________");
                    productManager.addProduct(scanner);
                    break;
                case 2:
                    System.out.println("\nRemove product");
                    System.out.println("_____________");
                    productManager.removeProductById(scanner);
                    break;
                case 3:
                    System.out.println("\nUpdate product details");
                    System.out.println("_____________");
                    productManager.updateProduct(scanner);
                    break;
                case 4:
                    System.out.println("\nView all products");
                    System.out.println("_____________");
                    productManager.displayAllProduct();
                    break;
                case 5:
                    System.out.println("\nSearch a product");
                    System.out.println("_____________");
                    productManager.displayFoundProduct(scanner);
                    break;
                case 6:
                    System.out.println("\nProduct recommendation");
                    System.out.println("_____________");
                    break;
                case 7:
                    System.out.println("\nCheck product availability");
                    System.out.println("_____________");
                    productManager.productAvailability(scanner);
                    break;
                case 8:
                    System.out.println("\nInventory value");
                    System.out.println("_____________");
                    productManager.totalInventory();
                    break;
                case 9:
                    System.out.println("\nPopular product");
                    System.out.println("_____________");
                    break;
                case 10:
                    System.out.println("\nPurchase a product");
                    System.out.println("_____________");
                case 11:
                    System.out.println("\nGoodbye");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Please choose a command: ");
        System.out.println("1. Add new product");
        System.out.println("2. Remove product");
        System.out.println("3. Update product info");
        System.out.println("4. View all products");
        System.out.println("5. Search a product");
        System.out.println("6. Product recommendation");
        System.out.println("7. Check product availability");
        System.out.println("8. Inventory value");
        System.out.println("9. Popular product");
        System.out.println("10. Purchased product");
        System.out.println("11. Exit");
    }
}