package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.util.HashSet;
import java.util.Set;


import org.junit.jupiter.api.Test;


import com.thbs.modal.Cart;
import com.thbs.modal.CartItem;
import com.thbs.modal.User;


public class CartTest {


    @Test
    public void testCartConstructor() {
        // Positive test case for constructor
        Cart cart = new Cart();
        assertNotNull(cart);
    }


    @Test
    public void testSetAndGetId() {
        // Positive test case for setting and getting id
        Long id = 1L;
        Cart cart = new Cart();
        cart.setId(id);
        assertEquals(id, cart.getId());
    }


    @Test
    public void testSetAndGetUser() {
        // Positive test case for setting and getting user
        User user = new User();
        Cart cart = new Cart();
        cart.setUser(user);
        assertEquals(user, cart.getUser());
    }


    @Test
    public void testSetAndGetCartItems() {
        // Positive test case for setting and getting cart items
        Set<CartItem> cartItems = new HashSet<>();
        CartItem cartItem = new CartItem();
        cartItems.add(cartItem);
        Cart cart = new Cart();
        cart.setCartItems(cartItems);
        assertEquals(cartItems, cart.getCartItems());
    }


    @Test
    public void testSetAndGetTotalPrice() {
        // Positive test case for setting and getting total price
        double totalPrice = 100.0;
        Cart cart = new Cart();
        cart.setTotalPrice(totalPrice);
        assertEquals(totalPrice, cart.getTotalPrice());
    }


    @Test
    public void testSetAndGetTotalItem() {
        // Positive test case for setting and getting total item
        int totalItem = 5;
        Cart cart = new Cart();
        cart.setTotalItem(totalItem);
        assertEquals(totalItem, cart.getTotalItem());
    }


    // Add more test cases as needed
}
