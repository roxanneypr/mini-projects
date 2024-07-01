package com.ecommerce.service;

import java.util.HashMap;
import java.util.Map;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

public class CartServiceImplementation implements CartService {
    private Map<String, Cart> cartMap;

    public CartServiceImplementation() {
        this.cartMap = new HashMap<>();
    }

    @Override
    public void addCart(Cart cart) {
        cartMap.put(cart.getCartId(), cart);
    }

    @Override
    public Cart getCart(String cartId) {
        return cartMap.get(cartId);
    }

    @Override
    public void addProductToCart(String cartId, Product product) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            cart.addProduct(product);
        }
    }

    @Override
    public void removeProductFromCart(String cartId, Product product) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            cart.removeProduct(product);
        }
    }

    @Override
    public double calculateTotalPrice(String cartId) {
        Cart cart = getCart(cartId);
        return (cart != null) ? cart.calculateTotalPrice() : 0;
    }
}
