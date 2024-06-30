package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

public interface CartService {
    void addCart(Cart cart);
    Cart getCart(String cartId);
    void addProductToCart(String cartId, Product product);
    void removeProductFromCart(String cartId, Product product);
    double calculateTotalPrice(String cartId);
}