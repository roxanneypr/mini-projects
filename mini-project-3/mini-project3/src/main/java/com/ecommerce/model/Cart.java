package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cartId;
    private List<Product> products;

    public Cart(String cartId) {
        this.cartId = cartId;
        this.products = new ArrayList<>();
    }

    public String getCartId() {
        return cartId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", products=" + products +
                '}';
    }
}
