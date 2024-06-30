package com.ecommerce;

import com.ecommerce.model.Product;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Laptop", 999.99, "Electronics");

        assertNotNull(product.getProductId());
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice(), 0.01);
        assertEquals("Electronics", product.getCategory());
    }
}
