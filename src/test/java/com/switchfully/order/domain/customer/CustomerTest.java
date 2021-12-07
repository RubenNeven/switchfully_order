package com.switchfully.order.domain.customer;

import com.switchfully.order.exception.InvalidCustomerException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void givenUserInputWithoutFirstName_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer(null, "Neven", "rubenneven@gmail.com", new Address("Pelserweg", "5", "Diepenbeek", "3590"), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in firstname");
    }

    @Test
    void givenUserInputWithoutLastName_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", null, "rubenneven@gmail.com", new Address("Pelserweg", "5", "Diepenbeek", "3590"), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in lastname");
    }

    @Test
    void givenUserInputWithoutEmailAddress_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", "Neven", null, new Address("Pelserweg", "5", "Diepenbeek", "3590"), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in email-address");
    }

    @Test
    void givenUserInputWithoutPhoneNumber_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", "Neven", "rubenneven@gmail.com", new Address("Pelserweg", "5", "Diepenbeek", "3590"), null))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in phone number");
    }

    @Test
    void givenUserInputWithoutStreet_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", "Neven", "rubenneven@gmail.com", new Address(null, "5", "Diepenbeek", "3590"), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in street");
    }

    @Test
    void givenUserInputWithoutHouseNumber_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", "Neven", "rubenneven@gmail.com", new Address("Pelserweg", null, "Diepenbeek", "3590"), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in house number");
    }

    @Test
    void givenUserInputWithoutCity_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", "Neven", "rubenneven@gmail.com", new Address("Pelserweg", "5", null, "3590"), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in city");
    }

    @Test
    void givenUserInputWithoutPostalCode_whenCreatingACustomer_thenThrowInvalidCustomerException(){
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Customer("Ruben", "Neven", "rubenneven@gmail.com", new Address("Pelserweg", "5", "Diepenbeek", null), "0484 48 29 78"))
                .isInstanceOf(InvalidCustomerException.class)
                .hasMessage("Please fill in postal code");
    }

    @Test
    void givenAValidInputString_whenCallingIsValidMethod_thenReturnTrue(){
        // Given
        String inputString = "Hello World";
        // When
        boolean validInput = Customer.isValidInput(inputString);
        // Then
        Assertions.assertThat(validInput).isTrue();
    }


}