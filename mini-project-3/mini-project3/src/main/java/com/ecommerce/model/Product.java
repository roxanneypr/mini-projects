package com.ecommerce.model;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Product {
    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    private String name;
    private double price;
    private String productId;

    public Product(String name, double price, String productId) {
        if (Objects.requireNonNullElse(name, "").isEmpty()) {
            logger.error("Product name cannot be null or empty.");
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (price < 0) {
            logger.error("Product price cannot be negative.");
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        if (Objects.requireNonNullElse(productId, "").isEmpty()) {
            logger.error("Product ID cannot be null or empty.");
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        this.name = name;
        this.price = price;
        this.productId = productId;
        logger.debug("Product created: {}", this);
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
