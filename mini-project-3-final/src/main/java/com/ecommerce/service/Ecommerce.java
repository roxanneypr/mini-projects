package com.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

/**
 * Ecommerce service class to manage products and carts.
 */
public class Ecommerce {
    private static final Logger logger = LoggerFactory.getLogger(Ecommerce.class);
    private CartService cartService;
    private ProductService productService;

    /**
     * Gets the service layer of the cart.
     *
     * @return the services of cart
     */
    public CartService getCartService() {
        return cartService;
    }

    /**
     * Gets the service layer of the product.
     *
     * @return the services of product
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * Constructor for Ecommerce.
     *
     * @param cartService the service to manage carts
     * @param productService the service to manage products
     */
    public Ecommerce(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    /**
     * Adds a product to the catalog.
     *
     * @param product the product to add
     */
    public void addProductToCatalog(Product product) {
        try {
            productService.addProduct(product);
            logger.debug("Product added to catalog: {}", product);
        } catch (Exception e) {
            logger.error("Failed to add product to catalog", e);
        }
    }

    /**
     * Adds a product to a cart.
     *
     * @param cartId the ID of the cart
     * @param product the product to add
     */
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

    /**
     * Removes a product from a cart.
     *
     * @param cartId the ID of the cart
     * @param product the product to remove
     */
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

    /**
     * Shows all products in a cart.
     *
     * @param cartId the ID of the cart
     */
    public void showProductsInCart(String cartId) {
        try {
            Cart cart = cartService.getCart(cartId);
            if (cart != null) {
                logger.debug("Products in cart: ");
                for (Product product : cart.getProducts()) {
                    System.out.println(product);
                }
            } else {
                logger.error("Cart with ID {} not found", cartId);
            }
        } catch (Exception e) {
            logger.error("Failed to show products in cart", e);
        }
    }

    /**
     * Calculates the total price of a cart.
     *
     * @param cartId the ID of the cart
     * @return the total price of the cart
     */
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

    /**
     * Lists all products in the catalog.
     */
    public void listAllProducts() {
        try {
            productService.listProducts();
        } catch (Exception e) {
            logger.error("Failed to list products", e);
        }
    }
}
