package com.ecommerce;

import com.ecommerce.model.Product;
import com.ecommerce.service.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductServiceImplementationTest {
    private ProductService productService;
    private Product product;

    @Before
    public void setUp() {
        productService = new ProductServiceImplementation();
        product = new Product("Laptop", 999.99, "Electronics");
    }

    @Test
    public void testAddProduct() {
        productService.addProduct(product);
        assertEquals(product, productService.getProduct(product.getProductId()));
    }

    @Test
    public void testGetProduct() {
        productService.addProduct(product);
        Product fetchedProduct = productService.getProduct(product.getProductId());
        assertEquals(product, fetchedProduct);
    }

    @Test
    public void testListProducts() {
        productService.addProduct(product);
        productService.listProducts();  // This should print the products, add assertion for better testing
        assertNotNull(productService.getProduct(product.getProductId()));
    }
}
