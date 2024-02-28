package com.thbs.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.time.LocalDate;


import org.junit.jupiter.api.Test;


import com.thbs.modal.PaymentInformation;


public class PaymentInformationTest {


    @Test
    public void testPaymentInformationConstructor() {
        // Positive test case for constructor
        PaymentInformation paymentInformation = new PaymentInformation();
        assertNotNull(paymentInformation);
    }


    @Test
    public void testSetAndGetCardholderName() {
        // Positive test case for setting and getting cardholder name
        String cardholderName = "John Doe";
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardholderName(cardholderName);
        assertEquals(cardholderName, paymentInformation.getCardholderName());
    }


    @Test
    public void testSetAndGetCardNumber() {
        // Positive test case for setting and getting card number
        String cardNumber = "1234567890123456";
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardNumber(cardNumber);
        assertEquals(cardNumber, paymentInformation.getCardNumber());
    }


    @Test
    public void testSetAndGetExpirationDate() {
        // Positive test case for setting and getting expiration date
        LocalDate expirationDate = LocalDate.now().plusYears(1);
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setExpirationDate(expirationDate);
        assertEquals(expirationDate, paymentInformation.getExpirationDate());
    }


    @Test
    public void testSetAndGetCvv() {
        // Positive test case for setting and getting CVV
        String cvv = "123";
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCvv(cvv);
        assertEquals(cvv, paymentInformation.getCvv());
    }


    
  

    @Test
    public void testToString() {
        // Positive test case for toString method
        PaymentInformation paymentInformation = new PaymentInformation();
        assertNotNull(paymentInformation.toString());
    }


    // Add more negative test cases for boundary conditions, null inputs, etc.
}