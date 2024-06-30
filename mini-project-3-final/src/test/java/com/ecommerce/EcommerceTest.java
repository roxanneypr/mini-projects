package com.ecommerce;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.service.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EcommerceTest {
    private Ecommerce ecommerce;
    private Cart cart;
    private Product product;

    @Before
    public void setUp() {
        CartService cartService = new CartServiceImplementation();
        ProductService productService = new ProductServiceImplementation();
        ecommerce = new Ecommerce(cartService, productService);
        cart = new Cart();
        cartService.addCart(cart);
        product = new Product("Laptop", 999.99, "Electronics");
        ecommerce.addProductToCatalog(product);
    }

    @Test
    public void testAddProductToCatalog() {
        assertNotNull(ecommerce.getProductService().getProduct(product.getProductId()));
    }

    @Test
    public void testAddProductToCart() {
        ecommerce.addProductToCart(cart.getCartId(), product);
        assertEquals(1, ecommerce.getCartService().getCart(cart.getCartId()).getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        ecommerce.addProductToCart(cart.getCartId(), product);
        ecommerce.removeProductFromCart(cart.getCartId(), product);
        assertTrue(ecommerce.getCartService().getCart(cart.getCartId()).getProducts().isEmpty());
    }

    @Test
    public void testShowProductsInCart() {
        ecommerce.addProductToCart(cart.getCartId(), product);
        ecommerce.showProductsInCart(cart.getCartId());
        assertEquals(1, ecommerce.getCartService().getCart(cart.getCartId()).getProducts().size());
    }

    @Test
    public void testCalculateCartTotal() {
        ecommerce.addProductToCart(cart.getCartId(), product);
        ecommerce.addProductToCart(cart.getCartId(), new Product("Smartphone", 499.99, "Electronics"));
        assertEquals(1499.98, ecommerce.calculateCartTotal(cart.getCartId()), 0.01);
    }
}
