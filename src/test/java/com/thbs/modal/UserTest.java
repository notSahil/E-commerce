package com.thbs.modal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.thbs.modal.Address;
import com.thbs.modal.PaymentInformation;
import com.thbs.modal.Rating;
import com.thbs.modal.Review;
import com.thbs.modal.User;
import com.thbs.user.domain.UserRole;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class UserTest {


    @Test
    public void testUserConstructor() {
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String password = "password";
        String email = "john.doe@example.com";
        UserRole role = UserRole.ROLE_ADMIN;
        String mobile = "1234567890";
        List<Address> addresses = new ArrayList<>();
        List<PaymentInformation> paymentInformation = new ArrayList<>();
        List<Rating> ratings = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();
        LocalDateTime createdAt = LocalDateTime.now();


        User user = new User(id, firstName, lastName, password, email, role, mobile, addresses, paymentInformation, ratings, reviews, createdAt);


        assertEquals(id, user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRole());
        assertEquals(mobile, user.getMobile());
        assertEquals(addresses, user.getAddresses());
        assertEquals(paymentInformation, user.getPaymentInformation());
        assertEquals(ratings, user.getRatings());
        assertEquals(reviews, user.getReviews());
        assertEquals(createdAt, user.getCreatedAt());
    }


    @Test
    public void testUserToString() {
        User user = new User();
        assertNotNull(user.toString());
    }


    @Test
    public void testGetId() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        assertEquals(id, user.getId());
    }


    @Test
    public void testGetFirstName() {
        String firstName = "John";
        User user = new User();
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }


    @Test
    public void testGetLastName() {
        String lastName = "Doe";
        User user = new User();
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }


    @Test
    public void testGetPassword() {
        String password = "password";
        User user = new User();
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }


    @Test
    public void testGetEmail() {
        String email = "john.doe@example.com";
        User user = new User();
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }


    @Test
    public void testGetRole() {
        UserRole role = UserRole.ROLE_ADMIN;
        User user = new User();
        user.setRole(role);
        assertEquals(role, user.getRole());
    }


    @Test
    public void testGetMobile() {
        String mobile = "1234567890";
        User user = new User();
        user.setMobile(mobile);
        assertEquals(mobile, user.getMobile());
    }


    @Test
    public void testGetAddresses() {
        List<Address> addresses = new ArrayList<>();
        Address address1 = new Address(null, "123 Street", "City", "12345", null, null, null, null, null);
        Address address2 = new Address(null, "456 Street", "City", "54321", null, null, null, null, null);
        addresses.add(address1);
        addresses.add(address2);
        User user = new User();
        user.setAddresses(addresses);
        assertEquals(addresses, user.getAddresses());
    }


    @Test
    public void testGetPaymentInformation() {
        List<PaymentInformation> paymentInformation = new ArrayList<>();
        PaymentInformation payment1 = new PaymentInformation();
        PaymentInformation payment2 = new PaymentInformation();
        paymentInformation.add(payment1);
        paymentInformation.add(payment2);
        User user = new User();
        user.setPaymentInformation(paymentInformation);
        assertEquals(paymentInformation, user.getPaymentInformation());
    }


   


    @Test
    public void testGetCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        User user = new User();
        user.setCreatedAt(createdAt);
        assertEquals(createdAt, user.getCreatedAt());
    }


    
    
  


    @Test
    public void testSetRatings() {
        List<Rating> ratings = new ArrayList<>();
        Rating rating1 = new Rating(null, null, null, 5, null);
        Rating rating2 = new Rating(null, null, null, 4, null);
        ratings.add(rating1);
        ratings.add(rating2);
        User user = new User();
        user.setRatings(ratings);
        assertEquals(ratings, user.getRatings());
    }


    @Test
    public void testSetReviews() {
        List<Review> reviews = new ArrayList<>();
        Review review1 = new Review(null, "Great product!", null, null, null);
        Review review2 = new Review(null, "Could be better.", null, null, null);
        reviews.add(review1);
        reviews.add(review2);
        User user = new User();
        user.setReviews(reviews);
        assertEquals(reviews, user.getReviews());
    }


    @Test
    public void testSetCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        User user = new User();
        user.setCreatedAt(createdAt);
        assertEquals(createdAt, user.getCreatedAt());
    }


    @Test
    public void testSetPassword() {
        String password = "password";
        User user = new User();
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }


    @Test
    public void testSetEmail() {
        String email = "john.doe@example.com";
        User user = new User();
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }
 


    @Test
    public void testNullFirstName() {
        String firstName = null;
        User user = new User();
        user.setFirstName(firstName);
        assertNull(user.getFirstName());
    }


    @Test
    public void testEmptyFirstName() {
        String emptyFirstName = "";
        User user = new User();
        user.setFirstName(emptyFirstName);
        assertTrue(user.getFirstName().isEmpty());
    }


   /* @Test
    public void testInvalidRole() {
        UserRole invalidRole = UserRole.valueOf("INVALID_ROLE");
        User user = new User();
        user.setRole(invalidRole);
        assertNull(user.getRole());
    }*/


    @Test
    public void testNullPaymentInformation() {
        List<PaymentInformation> paymentInformation = null;
        User user = new User();
        user.setPaymentInformation(paymentInformation);
        assertNull(user.getPaymentInformation());
    }


    @Test
    public void testNullAddresses() {
        List<Address> addresses = null;
        User user = new User();
        user.setAddresses(addresses);
        assertNull(user.getAddresses());
    }
    @Test
    public void testNullRatings() {
        List<Rating> ratings = null;
        User user = new User();
        user.setRatings(ratings);
        assertNull(user.getRatings());
    }


    @Test
    public void testNullReviews() {
        List<Review> reviews = null;
        User user = new User();
        user.setReviews(reviews);
        assertNull(user.getReviews());
    }

}
