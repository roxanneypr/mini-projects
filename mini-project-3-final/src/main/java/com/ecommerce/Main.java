package com.ecommerce;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CartService cartService = new CartServiceImplementation();
        ProductService productService = new ProductServiceImplementation();
        Ecommerce ecommerce = new Ecommerce(cartService, productService);

        // Adding products to the catalog
        Product laptop = new Product("Laptop", 999.99, "Electronics");
        Product smartphone = new Product("Smartphone", 499.99, "Electronics");
        Product tablet = new Product("Tablet", 299.99, "Electronics");
        Product headphones = new Product("Headphones", 149.99, "Electronics");
        Product keyboard = new Product("Keyboard", 79.99, "Electronics");
        Product monitor = new Product("Monitor", 199.99, "Electronics");
        Product mouse = new Product("Mouse", 49.99, "Electronics");

        // Adding products to the catalog
        ecommerce.addProductToCatalog(laptop);
        ecommerce.addProductToCatalog(smartphone);
        ecommerce.addProductToCatalog(tablet);
        ecommerce.addProductToCatalog(headphones);
        ecommerce.addProductToCatalog(keyboard);
        ecommerce.addProductToCatalog(monitor);
        ecommerce.addProductToCatalog(mouse);

        // Creating a cart
        Cart cart = new Cart();
        cartService.addCart(cart);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display all products
            System.out.println("\nAvailable Products:");
            ecommerce.listAllProducts();

            // Display menu options
            System.out.println("\nMain Menu:");
            System.out.println("[1] Add item to cart");
            System.out.println("[2] Remove item from cart");
            System.out.println("[3] Calculate total price in cart");
            System.out.println("[0] Exit");

            System.out.print("Enter your choice: ");
            int choice = -1;

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                logger.error("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
            }

            switch (choice) {
                case 1: // add item to cart
                    System.out.print("Enter Product ID to add to cart: ");
                    String productIdToAdd = scanner.nextLine();
                    Product productToAdd = productService.getProduct(productIdToAdd);
                    if (productToAdd != null) {
                        ecommerce.addProductToCart(cart.getCartId(), productToAdd);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 2: // remove item from cart
                    ecommerce.showProductsInCart(cart.getCartId());
                    System.out.print("Enter Product ID to remove from cart: ");
                    String productIdToRemove = scanner.nextLine();
                    Product productToRemove = productService.getProduct(productIdToRemove);
                    if (productToRemove != null) {
                        ecommerce.removeProductFromCart(cart.getCartId(), productToRemove);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3: // compute total price of items in cart
                    double total = ecommerce.calculateCartTotal(cart.getCartId());
                    System.out.println("Total price of the cart: " + total);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the e-commerce platform!");
    }
}
