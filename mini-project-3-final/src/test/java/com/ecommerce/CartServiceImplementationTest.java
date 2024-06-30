package com.ecommerce;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.service.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartServiceImplementationTest {
    private CartService cartService;
    private Cart cart;
    private Product product;

    @Before
    public void setUp() {
        cartService = new CartServiceImplementation();
        cart = new Cart();
        product = new Product("Laptop", 999.99, "Electronics");
        cartService.addCart(cart);
    }

    @Test
    public void testAddCart() {
        assertEquals(cart, cartService.getCart(cart.getCartId()));
    }

    @Test
    public void testGetCart() {
        assertNotNull(cartService.getCart(cart.getCartId()));
    }

    @Test
    public void testAddProductToCart() {
        cartService.addProductToCart(cart.getCartId(), product);
        assertEquals(1, cartService.getCart(cart.getCartId()).getProducts().size());
        assertEquals(product, cartService.getCart(cart.getCartId()).getProducts().get(0));
    }

    @Test
    public void testRemoveProductFromCart() {
        cartService.addProductToCart(cart.getCartId(), product);
        cartService.removeProductFromCart(cart.getCartId(), product);
        assertTrue(cartService.getCart(cart.getCartId()).getProducts().isEmpty());
    }

    @Test
    public void testCalculateTotalPrice() {
        cartService.addProductToCart(cart.getCartId(), product);
        cartService.addProductToCart(cart.getCartId(), new Product("Smartphone", 499.99, "Electronics"));
        assertEquals(1499.98, cartService.calculateTotalPrice(cart.getCartId()), 0.01);
    }
}
