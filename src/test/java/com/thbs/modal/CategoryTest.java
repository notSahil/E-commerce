package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;


import com.thbs.modal.Category;


public class CategoryTest {


    @Test
    public void testCategoryConstructor() {
        // Positive test case for constructor
        Category category = new Category();
        assertNotNull(category);
    }


    @Test
    public void testSetAndGetId() {
        // Positive test case for setting and getting id
        Long id = 1L;
        Category category = new Category();
        category.setId(id);
        assertEquals(id, category.getId());
    }


    @Test
    public void testSetAndGetName() {
        // Positive test case for setting and getting name
        String name = "CategoryName";
        Category category = new Category();
        category.setName(name);
        assertEquals(name, category.getName());
    }


    @Test
    public void testSetAndGetParentCategory() {
        // Positive test case for setting and getting parent category
        Category parentCategory = new Category();
        Category category = new Category();
        category.setParentCategory(parentCategory);
        assertEquals(parentCategory, category.getParentCategory());
    }


    @Test
    public void testSetAndGetLevel() {
        // Positive test case for setting and getting level
        int level = 1;
        Category category = new Category();
        category.setLevel(level);
        assertEquals(level, category.getLevel());
    }




    @Test
    public void testToString() {
        // Positive test case for toString method
        Category category = new Category();
        assertNotNull(category.toString());
    }


    // Add more negative test cases for boundary conditions, null inputs, etc.
}
