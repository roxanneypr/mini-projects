package com.ecommerce;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartTest {
    private Cart cart;

    @Before
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("Laptop", 999.99, "Electronics");
        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product("Laptop", 999.99, "Electronics");
        cart.addProduct(product);
        cart.removeProduct(product);

        assertEquals(0, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product));
    }

    @Test
    public void testCalculateTotalPrice() {
        Product laptop = new Product("Laptop", 999.99, "Electronics");
        Product smartphone = new Product("Smartphone", 499.99, "Electronics");
        cart.addProduct(laptop);
        cart.addProduct(smartphone);

        assertEquals(1499.98, cart.calculateTotalPrice(), 0.01);
    }
}
