package com.ecommerce.service;

import com.ecommerce.model.Product;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the ProductService interface.
 * Manages a catalog of products using an in-memory data structure.
 */
public class ProductServiceImplementation implements ProductService {
    private Map<String, Product> products = new HashMap<>();

    /**
     * Adds a product to the catalog.
     *
     * @param product the product to add
     */
    @Override
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    /**
     * Retrieves a product from the catalog by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the product with the specified ID, or null if not found
     */
    @Override
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    /**
     * Lists all products in the catalog.
     * If no products are available, a message is displayed indicating that.
     */
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
