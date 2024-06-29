package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.model.Product;

public class CartServiceImpl implements CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private List<Product> products;

    public CartServiceImpl() {
        this.products = new ArrayList<>();
        logger.debug("CartServiceImpl initialized.");
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            logger.error("Cannot add null product to the cart.");
            throw new IllegalArgumentException("Cannot add null product to the cart.");
        }
        products.add(product);
        logger.debug("Product added to cart: {}", product);
    }

    @Override
    public void viewCart() {
        if (products.isEmpty()) {
            logger.info("The cart is empty.");
        } else {
            logger.info("Products in the cart:");
            for (Product product : products) {
                logger.info("{}", product);
            }
        }
    }

    @Override
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        logger.debug("Total price calculated: {}", total);
        return total;
    }
}
