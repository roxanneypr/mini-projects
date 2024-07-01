package com.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

public class Ecommerce {
    private static final Logger logger = LoggerFactory.getLogger(Ecommerce.class);
    private CartService cartService;
    private ProductService productService;

    public Ecommerce(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    // Add a product to the catalog
    public void addProductToCatalog(Product product) {
        try {
            productService.addProduct(product);
            logger.debug("Product added to catalog: {}", product);
        } catch (Exception e) {
            logger.error("Failed to add product to catalog", e);
        }
    }

    // Add a product to a cart
    public void addProductToCart(String cartId, Product product) {
        try {
            Cart cart = cartService.getCart(cartId);
            if (cart != null) {
                cart.addProduct(product);
                logger.debug("Product added to cart: {}", product);
            } else {
                logger.error("Cart with ID {} not found", cartId);
            }
        } catch (Exception e) {
            logger.error("Failed to add product to cart", e);
        }
    }

    // Remove a product from a cart
    public void removeProductFromCart(String cartId, Product product) {
        try {
            Cart cart = cartService.getCart(cartId);
            if (cart != null) {
                cart.removeProduct(product);
                logger.debug("Product removed from cart: {}", product);
            } else {
                logger.error("Cart with ID {} not found", cartId);
            }
        } catch (Exception e) {
            logger.error("Failed to remove product from cart", e);
        }
    }

    // Calculate total price of a cart
    public double calculateCartTotal(String cartId) {
        try {
            Cart cart = cartService.getCart(cartId);
            if (cart != null) {
                double total = cart.calculateTotalPrice();
                logger.debug("Total price for cart {}: {}", cartId, total);
                return total;
            } else {
                logger.error("Cart with ID {} not found", cartId);
            }
        } catch (Exception e) {
            logger.error("Failed to calculate total for cart", e);
        }
        return 0;
    }

    // List all products in the catalog
    public void listAllProducts() {
        try {
            productService.listProducts();
        } catch (Exception e) {
            logger.error("Failed to list products", e);
        }
    }
}
