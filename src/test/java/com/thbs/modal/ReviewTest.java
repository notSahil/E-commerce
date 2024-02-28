package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import com.thbs.modal.Product;
import com.thbs.modal.Review;
import com.thbs.modal.User;


public class ReviewTest {


    @Test
    public void testReviewConstructor() {
        Long id = 1L;
        String reviewText = "This is a great product!";
        Product product = new Product();
        User user = new User();
        LocalDateTime createdAt = LocalDateTime.now();


        Review review = new Review(id, reviewText, product, user, createdAt);


        assertEquals(id, review.getId());
        assertEquals(reviewText, review.getReview());
        assertEquals(product, review.getProduct());
        assertEquals(user, review.getUser());
        assertEquals(createdAt, review.getCreatedAt());
    }


    @Test
    public void testGetCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        Review review = new Review();
        review.setCreatedAt(createdAt);
        assertEquals(createdAt, review.getCreatedAt());
    }


    @Test
    public void testGetUser() {
        User user = new User();
        Review review = new Review();
        review.setUser(user);
        assertEquals(user, review.getUser());
    }


    @Test
    public void testGetId() {
        Long id = 1L;
        Review review = new Review();
        review.setId(id);
        assertEquals(id, review.getId());
    }


    @Test
    public void testGetReview() {
        String reviewText = "This is a great product!";
        Review review = new Review();
        review.setReview(reviewText);
        assertEquals(reviewText, review.getReview());
    }


    @Test
    public void testGetProduct() {
        Product product = new Product();
        Review review = new Review();
        review.setProduct(product);
        assertEquals(product, review.getProduct());
    }
}