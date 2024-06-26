package com.ecommerce;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add product to cart");
            System.out.println("2. View cart");
            System.out.println("3. Calculate total price");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter product ID: ");
                        String productId = scanner.nextLine();
                        Product product = new Product(name, price, productId);
                        cart.addProduct(product);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    System.out.println("Total price: " + cart.calculateTotalPrice());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 3.");
            }
        }
    }
}
