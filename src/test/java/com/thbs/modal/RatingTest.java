package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import com.thbs.modal.Product;
import com.thbs.modal.Rating;
import com.thbs.modal.User;


public class RatingTest {


    @Test
    public void testRatingConstructor() {
        Long id = 1L;
        User user = new User();
        Product product = new Product();
        double ratingValue = 4.5;
        LocalDateTime createdAt = LocalDateTime.now();


        Rating rating = new Rating(id, user, product, ratingValue, createdAt);


        assertEquals(id, rating.getId());
        assertEquals(user, rating.getUser());
        assertEquals(product, rating.getProduct());
        assertEquals(ratingValue, rating.getRating());
        assertEquals(createdAt, rating.getCreatedAt());
    }


    @Test
    public void testGetCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        Rating rating = new Rating();
        rating.setCreatedAt(createdAt);
        assertEquals(createdAt, rating.getCreatedAt());
    }


    @Test
    public void testGetUser() {
        User user = new User();
        Rating rating = new Rating();
        rating.setUser(user);
        assertEquals(user, rating.getUser());
    }


    @Test
    public void testGetId() {
        Long id = 1L;
        Rating rating = new Rating();
        rating.setId(id);
        assertEquals(id, rating.getId());
    }


    @Test
    public void testGetProduct() {
        Product product = new Product();
        Rating rating = new Rating();
        rating.setProduct(product);
        assertEquals(product, rating.getProduct());
    }


    @Test
    public void testGetRating() {
        double ratingValue = 4.5;
        Rating rating = new Rating();
        rating.setRating(ratingValue);
        assertEquals(ratingValue, rating.getRating());
    }
}
