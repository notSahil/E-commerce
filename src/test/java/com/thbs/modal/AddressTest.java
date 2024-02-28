package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;


import com.thbs.modal.Address;
import com.thbs.modal.User;


public class AddressTest {


    @Test
    public void testAddressConstructor() {
        // Positive test case for constructor
        Address address = new Address();
        assertNotNull(address);
    }


    @Test
    public void testSetAndGetId() {
        // Positive test case for setting and getting id
        Long id = 1L;
        Address address = new Address();
        address.setId(id);
        assertEquals(id, address.getId());
    }


    @Test
    public void testSetAndGetFirstName() {
        // Positive test case for setting and getting first name
        String firstName = "John";
        Address address = new Address();
        address.setFirstName(firstName);
        assertEquals(firstName, address.getFirstName());
    }


    @Test
    public void testSetAndGetLastName() {
        // Positive test case for setting and getting last name
        String lastName = "Doe";
        Address address = new Address();
        address.setLastName(lastName);
        assertEquals(lastName, address.getLastName());
    }


    @Test
    public void testSetAndGetStreetAddress() {
        // Positive test case for setting and getting street address
        String streetAddress = "123 Main St";
        Address address = new Address();
        address.setStreetAddress(streetAddress);
        assertEquals(streetAddress, address.getStreetAddress());
    }


    @Test
    public void testSetAndGetCity() {
        // Positive test case for setting and getting city
        String city = "Anytown";
        Address address = new Address();
        address.setCity(city);
        assertEquals(city, address.getCity());
    }


    @Test
    public void testSetAndGetState() {
        // Positive test case for setting and getting state
        String state = "CA";
        Address address = new Address();
        address.setState(state);
        assertEquals(state, address.getState());
    }


    @Test
    public void testSetAndGetZipCode() {
        // Positive test case for setting and getting zip code
        String zipCode = "12345";
        Address address = new Address();
        address.setZipCode(zipCode);
        assertEquals(zipCode, address.getZipCode());
    }


    @Test
    public void testSetAndGetMobile() {
        // Positive test case for setting and getting mobile
        String mobile = "123-456-7890";
        Address address = new Address();
        address.setMobile(mobile);
        assertEquals(mobile, address.getMobile());
    }


    // Add more test cases as needed
}