package com.model;

public class Address {

    private final String street;
    private final String houseNumber;

    public Address(String street, String houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return String.format("{\"street\": \"%s\", \"housenumber\": \"%s\"}", this.street, this.houseNumber);
    }
}
