package com.thbs.modal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.thbs.modal.Size;


public class SizeTest {


    @Test
    public void testSetName() {
        String name = "Small";
        Size size = new Size();
        size.setName(name);
        assertEquals(name, size.getName());
    }


    @Test
    public void testSetQuantity() {
        int quantity = 10;
        Size size = new Size();
        size.setQuantity(quantity);
        assertEquals(quantity, size.getQuantity());
    }


    @Test
    public void testNullName() {
        String name = null;
        Size size = new Size();
        size.setName(name);
        assertNull(size.getName());
    }


    @Test
    public void testNegativeQuantity() {
        int quantity = -5;
        Size size = new Size();
        size.setQuantity(quantity);
        assertEquals(quantity, size.getQuantity());
    }
}