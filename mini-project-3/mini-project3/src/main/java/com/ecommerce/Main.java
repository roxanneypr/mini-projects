package com.ecommerce;

import java.util.Scanner;

import com.ecommerce.model.Product;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CartServiceImpl;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        CartService cartService = new CartServiceImpl();
        ProductService productService = new ProductServiceImpl();
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
                        Product product = productService.createProduct(name, price, productId);
                        cartService.addProduct(product);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } /* catch (NumberFormatException e) {
                        System.out.println("Invalid price. Please enter a valid number.");
                    } */
                    break;
                case 2:
                    cartService.viewCart();
                    break;
                case 3:
                    System.out.println("Total price: " + cartService.calculateTotalPrice());
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
