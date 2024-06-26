package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot add null product to the cart.");
        }
        products.add(product);
        System.out.println("Product added to cart: " + product);
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Products in the cart:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

