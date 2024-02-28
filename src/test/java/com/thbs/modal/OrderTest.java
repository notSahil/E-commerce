package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;


import com.thbs.modal.Address;
import com.thbs.modal.Order;
import com.thbs.modal.OrderItem;
import com.thbs.modal.PaymentDetails;
import com.thbs.modal.User;
import com.thbs.user.domain.OrderStatus;


public class OrderTest {


    @Test
    public void testOrderConstructor() {
        // Positive test case for constructor
        Order order = new Order();
        assertNotNull(order);
    }


    @Test
    public void testSetAndGetUser() {
        // Positive test case for setting and getting user
        User user = new User();
        Order order = new Order();
        order.setUser(user);
        assertEquals(user, order.getUser());
    }


    @Test
    public void testSetAndGetOrderItems() {
        // Positive test case for setting and getting order items
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItems.add(orderItem);
        Order order = new Order();
        order.setOrderItems(orderItems);
        assertEquals(orderItems, order.getOrderItems());
    }


    @Test
    public void testSetAndGetOrderDate() {
        // Positive test case for setting and getting order date
        LocalDateTime orderDate = LocalDateTime.now();
        Order order = new Order();
        order.setOrderDate(orderDate);
        assertEquals(orderDate, order.getOrderDate());
    }


    @Test
    public void testSetAndGetDeliveryDate() {
        // Positive test case for setting and getting delivery date
        LocalDateTime deliveryDate = LocalDateTime.now();
        Order order = new Order();
        order.setDeliveryDate(deliveryDate);
        assertEquals(deliveryDate, order.getDeliveryDate());
    }


    @Test
    public void testSetAndGetShippingAddress() {
        // Positive test case for setting and getting shipping address
        Address address = new Address();
        Order order = new Order();
        order.setShippingAddress(address);
        assertEquals(address, order.getShippingAddress());
    }


    @Test
    public void testSetAndGetPaymentDetails() {
        // Positive test case for setting and getting payment details
        PaymentDetails paymentDetails = new PaymentDetails();
        Order order = new Order();
        order.setPaymentDetails(paymentDetails);
        assertEquals(paymentDetails, order.getPaymentDetails());
    }


    @Test
    public void testSetAndGetTotalPrice() {
        // Positive test case for setting and getting total price
        double totalPrice = 100.0;
        Order order = new Order();
        order.setTotalPrice(totalPrice);
        assertEquals(totalPrice, order.getTotalPrice());
    }


    @Test
    public void testSetAndGetOrderStatus() {
        // Positive test case for setting and getting order status
        OrderStatus orderStatus = OrderStatus.PENDING;
        Order order = new Order();
        order.setOrderStatus(orderStatus);
        assertEquals(orderStatus, order.getOrderStatus());
    }


    @Test
    public void testSetAndGetTotalItem() {
        // Positive test case for setting and getting total item
        int totalItem = 5;
        Order order = new Order();
        order.setTotalItem(totalItem);
        assertEquals(totalItem, order.getTotalItem());
    }


    @Test
    public void testSetAndGetCreatedAt() {
        // Positive test case for setting and getting created at date
        LocalDateTime createdAt = LocalDateTime.now();
        Order order = new Order();
        order.setCreatedAt(createdAt);
        assertEquals(createdAt, order.getCreatedAt());
    }


   

    @Test
    public void testToString() {
        // Positive test case for toString method
        Order order = new Order();
        assertNotNull(order.toString());
    }


    // Add more negative test cases for boundary conditions, null inputs, etc.
}
