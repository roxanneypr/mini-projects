package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartServiceImplementation implements CartService {
    private Map<String, Cart> cartMap;

    /**
     * Constructs a new CartServiceImplementation.
     * Initializes the cart map.
     */
    public CartServiceImplementation() {
        this.cartMap = new HashMap<>();
    }

    /**
     * Adds a cart to the cart map.
     *
     * @param cart the cart to add
     */
    @Override
    public void addCart(Cart cart) {
        cartMap.put(cart.getCartId(), cart);
    }

    /**
     * Retrieves a cart by its ID.
     *
     * @param cartId the ID of the cart to retrieve
     * @return the cart with the specified ID, or null if not found
     */
    @Override
    public Cart getCart(String cartId) {
        return cartMap.get(cartId);
    }

    /**
     * Adds a product to a cart.
     *
     * @param cartId the ID of the cart
     * @param product the product to add
     */
    @Override
    public void addProductToCart(String cartId, Product product) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            cart.addProduct(product);
        }
    }

    /**
     * Removes a product from a cart.
     *
     * @param cartId the ID of the cart
     * @param product the product to remove
     */
    @Override
    public void removeProductFromCart(String cartId, Product product) {
        Cart cart = getCart(cartId);
        if (cart != null) {
            cart.removeProduct(product);
        }
    }

    /**
     * Calculates the total price of the products in a cart.
     *
     * @param cartId the ID of the cart
     * @return the total price of the products in the cart, or 0 if the cart is not found
     */
    @Override
    public double calculateTotalPrice(String cartId) {
        Cart cart = getCart(cartId);
        return (cart != null) ? cart.calculateTotalPrice() : 0;
    }
}
