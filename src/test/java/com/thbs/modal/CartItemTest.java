package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;


import com.thbs.modal.CartItem;
import com.thbs.modal.Cart;
import com.thbs.modal.Product;


public class CartItemTest {


    @Test
    public void testCartItemConstructor() {
        // Positive test case for constructor
        CartItem cartItem = new CartItem();
        assertNotNull(cartItem);
    }


    @Test
    public void testSetAndGetId() {
        // Positive test case for setting and getting id
        Long id = 1L;
        CartItem cartItem = new CartItem();
        cartItem.setId(id);
        assertEquals(id, cartItem.getId());
    }


    @Test
    public void testSetAndGetPrice() {
        // Positive test case for setting and getting price
        Integer price = 100;
        CartItem cartItem = new CartItem();
        cartItem.setPrice(price);
        assertEquals(price, cartItem.getPrice());
    }


    @Test
    public void testSetAndGetProduct() {
        // Positive test case for setting and getting product
        Product product = new Product();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        assertEquals(product, cartItem.getProduct());
    }


    @Test
    public void testSetAndGetSize() {
        // Positive test case for setting and getting size
        String size = "M";
        CartItem cartItem = new CartItem();
        cartItem.setSize(size);
        assertEquals(size, cartItem.getSize());
    }


 


    @Test
    public void testToString() {
        // Positive test case for toString method
        CartItem cartItem = new CartItem();
        assertNotNull(cartItem.toString());
    }


    // Add more negative test cases for boundary conditions, null inputs, etc.
}
