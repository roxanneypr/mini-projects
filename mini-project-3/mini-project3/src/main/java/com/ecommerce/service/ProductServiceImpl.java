package com.ecommerce.service;

import com.ecommerce.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product createProduct(String name, double price, String productId) {
        try {
            Product product = new Product(name, price, productId);
            logger.debug("Product created: {}", product);
            return product;
        } catch (IllegalArgumentException e) {
            logger.error("Error creating product: {}", e.getMessage());
            throw e;
        }
    }
}
