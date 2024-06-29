package com.ecommerce.service;

import com.ecommerce.model.Product;

public interface ProductService {
    Product createProduct(String name, double price, String productId);
}
