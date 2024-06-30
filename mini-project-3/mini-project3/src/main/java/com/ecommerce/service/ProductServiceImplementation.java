package com.ecommerce.service;

import com.ecommerce.model.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductServiceImplementation implements ProductService {
    private Map<String, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    @Override
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}
