package com.ecommerce.model;
import java.util.UUID;

/**
 * Represents a product in the e-commerce application.
 * Contains a unique identifier, name, price, and category.
 */
public class Product {
    private String productId;
    private String name;
    private double price;
    private String category;

    /**
     * Constructs a new Product with the specified name, price, and category.
     * Generates a unique product ID.
     *
     * @param name     the name of the product
     * @param price    the price of the product
     * @param category the category of the product
     */
    public Product(String name, double price, String category) {
        this.productId = UUID.randomUUID().toString();;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Gets the unique product ID.
     *
     * @return the product ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the category of the product.
     *
     * @return the category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return a string representation of the product
     */
    @Override
    public String toString() {
        return String.format("%-15s %s\t%-15s %s\t%-15s %.2f\t%-15s %s",
                "productId:", productId,
                "name:", name,
                "price:", price,
                "category:", category);
    }
}
