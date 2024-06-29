package com.ecommerce.service;

import com.ecommerce.model.Product;

public interface CartService {
    void addProduct(Product product);
    void viewCart();
    double calculateTotalPrice();
}
