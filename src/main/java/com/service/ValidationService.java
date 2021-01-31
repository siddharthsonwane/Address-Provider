package com.service;

import org.springframework.util.Assert;

public class ValidationService {

    public String validateInput(String inputValue) {

        Assert.isTrue(inputValue != null, "Address may not be null");
        Assert.isTrue(!inputValue.equals(""), "Address may not be empty");
        Assert.isTrue(containNumeric(inputValue), "House number is missing");
        Assert.isTrue(containCharacter(inputValue), "Street Name is missing");

        return inputValue.trim();

    }

    private boolean containNumeric(String inputValue) {

        for (char c : inputValue.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containCharacter(String inputValue) {

        for (char c : inputValue.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return true;
            }
        }
        return false;
    }
}
