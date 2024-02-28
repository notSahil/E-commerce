package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import com.thbs.modal.Category;
import com.thbs.modal.Product;
import com.thbs.modal.Rating;
import com.thbs.modal.Review;
import com.thbs.modal.Size;


public class ProductTest {


    @Test
    public void testProductConstructor() {
        Long id = 1L;
        String title = "Product Title";
        String description = "Product Description";
        int price = 100;
        int discountedPrice = 90;
        int discountPersent = 10;
        int quantity = 50;
        String brand = "Brand";
        String color = "Color";
        Set<Size> sizes = new HashSet<>();
        sizes.add(new Size());
        sizes.add(new Size());
        String imageUrl = "Image URL";
        List<Rating> ratings = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();
        int numRatings = 100;
        Category category = new Category();
        LocalDateTime createdAt = LocalDateTime.now();


        Product product = new Product(id, title, description, price, discountedPrice, discountPersent, quantity,
                brand, color, sizes, imageUrl, ratings, reviews, numRatings, category, createdAt);


        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(description, product.getDescription());
        assertEquals(price, product.getPrice());
        assertEquals(discountedPrice, product.getDiscountedPrice());
        assertEquals(discountPersent, product.getDiscountPersent());
        assertEquals(quantity, product.getQuantity());
        assertEquals(brand, product.getBrand());
        assertEquals(color, product.getColor());
        assertEquals(sizes, product.getSizes());
        assertEquals(imageUrl, product.getImageUrl());
        assertEquals(ratings, product.getRatings());
        assertEquals(reviews, product.getReviews());
        assertEquals(numRatings, product.getNumRatings());
        assertEquals(category, product.getCategory());
        assertEquals(createdAt, product.getCreatedAt());
    }


   

    @Test
    public void testSetAndGetId() {
        // Positive test case for setting and getting id
        Long id = 1L;
        Product product = new Product();
        product.setId(id);
        assertEquals(id, product.getId());
    }


    @Test
    public void testSetAndGetTitle() {
        // Positive test case for setting and getting title
        String title = "Product Title";
        Product product = new Product();
        product.setTitle(title);
        assertEquals(title, product.getTitle());
    }


    @Test
    public void testSetAndGetDescription() {
        // Positive test case for setting and getting description
        String description = "Product Description";
        Product product = new Product();
        product.setDescription(description);
        assertEquals(description, product.getDescription());
    }


    @Test
    public void testSetAndGetPrice() {
        // Positive test case for setting and getting price
        int price = 100;
        Product product = new Product();
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }


    @Test
    public void testSetAndGetDiscountedPrice() {
        // Positive test case for setting and getting discounted price
        int discountedPrice = 80;
        Product product = new Product();
        product.setDiscountedPrice(discountedPrice);
        assertEquals(discountedPrice, product.getDiscountedPrice());
    }


    @Test
    public void testSetAndGetDiscountPercent() {
        // Positive test case for setting and getting discount percent
        int discountPercent = 20;
        Product product = new Product();
        product.setDiscountPersent(discountPercent);
        assertEquals(discountPercent, product.getDiscountPersent());
    }


    @Test
    public void testSetAndGetQuantity() {
        // Positive test case for setting and getting quantity
        int quantity = 10;
        Product product = new Product();
        product.setQuantity(quantity);
        assertEquals(quantity, product.getQuantity());
    }


    @Test
    public void testSetAndGetBrand() {
        // Positive test case for setting and getting brand
        String brand = "Brand";
        Product product = new Product();
        product.setBrand(brand);
        assertEquals(brand, product.getBrand());
    }


    @Test
    public void testSetAndGetColor() {
        // Positive test case for setting and getting color
        String color = "Color";
        Product product = new Product();
        product.setColor(color);
        assertEquals(color, product.getColor());
    }


    @Test
    public void testSetAndGetSizes() {
        // Positive test case for setting and getting sizes
        Set<Size> sizes = new HashSet<>();
        Size size1 = new Size();
        Size size2 = new Size();
        sizes.add(size1);
        sizes.add(size2);


        Product product = new Product();
        product.setSizes(sizes);


        assertEquals(sizes, product.getSizes());
    }


    @Test
    public void testSetAndGetImageUrl() {
        // Positive test case for setting and getting image URL
String imageUrl = "http://example.com/image.jpg";
        Product product = new Product();
        product.setImageUrl(imageUrl);
        assertEquals(imageUrl, product.getImageUrl());
    }


    @Test
    public void testSetAndGetRatings() {
        // Positive test case for setting and getting ratings
        List<Rating> ratings = new ArrayList<>();
        Rating rating1 = new Rating();
        Rating rating2 = new Rating();
        ratings.add(rating1);
        ratings.add(rating2);


        Product product = new Product();
        product.setRatings(ratings);


        assertEquals(ratings, product.getRatings());
    }


    @Test
    public void testSetAndGetReviews() {
        // Positive test case for setting and getting reviews
        List<Review> reviews = new ArrayList<>();
        Review review1 = new Review();
        Review review2 = new Review();
        reviews.add(review1);
        reviews.add(review2);


        Product product = new Product();
        product.setReviews(reviews);


        assertEquals(reviews, product.getReviews());
    }


    @Test
    public void testSetAndGetNumRatings() {
        // Positive test case for setting and getting number of ratings
        int numRatings = 100;
        Product product = new Product();
        product.setNumRatings(numRatings);
        assertEquals(numRatings, product.getNumRatings());
    }


    @Test
    public void testSetAndGetCategory() {
        // Positive test case for setting and getting category
        Category category = new Category();
        Product product = new Product();
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }


    @Test
    public void testSetAndGetCreatedAt() {
        // Positive test case for setting and getting createdAt
        LocalDateTime createdAt = LocalDateTime.now();
        Product product = new Product();
        product.setCreatedAt(createdAt);
        assertEquals(createdAt, product.getCreatedAt());
    }


    @Test
    public void testEqualsAndHashCode() {
        // Positive test case for equals and hashCode methods
        Product product1 = new Product();
        Product product2 = new Product();
        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());


        // Negative test case for equals method
        Product product3 = new Product();
        product3.setId(1L);
        assertNotEquals(product1, product3);
    }


    @Test
    public void testToString() {
        // Positive test case for toString method
        Product product = new Product();
        assertNotNull(product.toString());
    }


    // Add similar tests for other getters and setters
}
