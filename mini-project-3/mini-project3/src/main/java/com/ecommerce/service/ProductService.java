package com.ecommerce.service;

import com.ecommerce.model.Product;

public interface ProductService {
    void addProduct(Product product);
    Product getProduct(String productId);
    void listProducts();
}
