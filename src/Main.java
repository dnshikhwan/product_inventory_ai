/*
1. Add new product []
2. Remove by product id []
3. Update product info []
4. View all products []
5. Search product by name or category []
6. Product recommendation []
7. Check product availability []
8. Inventory value calculation []
9. Product popularity analysis []
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    break;
                case 2:
                    System.out.println("\nRemove product");
                    break;
                case 3:
                    System.out.println("\nUpdate product info");
                    break;
                case 4:
                    System.out.println("\nView all products");
                    break;
                case 5:
                    System.out.println("\nSearch a product");
                    break;
                case 6:
                    System.out.println("\nProduct recommendation");
                    break;
                case 7:
                    System.out.println("\nCheck product availability");
                    break;
                case 8:
                    System.out.println("\nInventory value");
                    break;
                case 9:
                    System.out.println("\nPopular product");
                    break;
                case 10:
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
        System.out.println("10. Exit");
    }
}