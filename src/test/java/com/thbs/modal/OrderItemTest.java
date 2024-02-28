package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.time.LocalDateTime;


import org.junit.jupiter.api.Test;


import com.thbs.modal.Order;
import com.thbs.modal.OrderItem;
import com.thbs.modal.Product;


public class OrderItemTest {


    @Test
    public void testOrderItemConstructor() {
        // Positive test case for constructor
        OrderItem orderItem = new OrderItem();
        assertNotNull(orderItem);
    }


    @Test
    public void testSetAndGetOrder() {
        // Positive test case for setting and getting order
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        assertEquals(order, orderItem.getOrder());
    }


    @Test
    public void testSetAndGetProduct() {
        // Positive test case for setting and getting product
        Product product = new Product();
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        assertEquals(product, orderItem.getProduct());
    }


    @Test
    public void testSetAndGetSize() {
        // Positive test case for setting and getting size
        String size = "M";
        OrderItem orderItem = new OrderItem();
        orderItem.setSize(size);
        assertEquals(size, orderItem.getSize());
    }


    @Test
    public void testSetAndGetQuantity() {
        // Positive test case for setting and getting quantity
        int quantity = 2;
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(quantity);
        assertEquals(quantity, orderItem.getQuantity());
    }


    @Test
    public void testSetAndGetPrice() {
        // Positive test case for setting and getting price
        Integer price = 100;
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(price);
        assertEquals(price, orderItem.getPrice());
    }


    @Test
    public void testSetAndGetUserId() {
        // Positive test case for setting and getting user ID
        Long userId = 123L;
        OrderItem orderItem = new OrderItem();
        orderItem.setUserId(userId);
        assertEquals(userId, orderItem.getUserId());
    }


    @Test
    public void testSetAndGetDeliveryDate() {
        // Positive test case for setting and getting delivery date
        LocalDateTime deliveryDate = LocalDateTime.now();
        OrderItem orderItem = new OrderItem();
        orderItem.setDeliveryDate(deliveryDate);
        assertEquals(deliveryDate, orderItem.getDeliveryDate());
    }


    @Test
    public void testEqualsAndHashCode() {
        // Positive test case for equals and hashCode methods
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();
        assertEquals(orderItem1, orderItem2);
        assertEquals(orderItem1.hashCode(), orderItem2.hashCode());


        // Negative test case for equals method
        OrderItem orderItem3 = new OrderItem();
        orderItem3.setProduct(new Product());
        assertNotEquals(orderItem1, orderItem3);
    }


    @Test
    public void testToString() {
        // Positive test case for toString method
        OrderItem orderItem = new OrderItem();
        assertNotNull(orderItem.toString());
    }


    // Add more negative test cases for boundary conditions, null inputs, etc.
}
