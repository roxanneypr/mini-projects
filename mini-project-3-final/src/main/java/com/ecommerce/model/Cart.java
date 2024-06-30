package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a shopping cart in the e-commerce application.
 * Contains a unique identifier and a list of products.
 */
public class Cart {
    private String cartId;
    private List<Product> products;

    /**
     * Constructs a new Cart.
     * Generates a unique cart ID and initializes the product list.
     */
    public Cart() {
        this.cartId = UUID.randomUUID().toString();
        this.products = new ArrayList<>();
    }

    /**
     * Gets the unique cart ID.
     *
     * @return the cart ID
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * Gets the list of products in the cart.
     *
     * @return the list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Adds a product to the cart.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the cart.
     *
     * @param product the product to remove
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Calculates the total price of all products in the cart.
     *
     * @return the total price
     */
    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    /**
     * Returns a string representation of the cart.
     *
     * @return a string representation of the cart
     */
    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", products=" + products +
                '}';
    }
}
