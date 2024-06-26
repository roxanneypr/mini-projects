package com.ecommerce;

public class Product {
    private String name;
    private double price;
    private String productId;

    public Product(String name, double price, String productId) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", productId='" + productId + '\'' +
                '}';
    }
}

