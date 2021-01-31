package com.service;

import com.model.Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressService {

    public static String calculateAddress(String address) {

        StringBuilder houseBuilder = new StringBuilder();
        StringBuilder streetBuilder = new StringBuilder();

        String houseNumber;
        String street;

        Pattern space = Pattern.compile("\\s+");
        Matcher matcherSpace = space.matcher(address);

        boolean containsSpace = matcherSpace.find();

        if (containsSpace && address.contains(",")) {

            String[] spaceAndCommaSplitArray = address.split(",");

            for (int i = 0; i < spaceAndCommaSplitArray.length; i++) {

                String value = spaceAndCommaSplitArray[i];

                if (Character.isDigit(value.charAt(0)) ||
                        value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                    houseBuilder.append(spaceAndCommaSplitArray[i]);
                    houseBuilder.append(" ");

                } else {
                    streetBuilder.append(spaceAndCommaSplitArray[i]);
                    streetBuilder.append(" ");

                }

            }
        } else if (containsSpace) {

            String[] spaceSplitArray = address.split("\\s+");

            if (spaceSplitArray.length == 4) {

                String[] camelCaseArray = address.split("(?=[A-Z])");
                houseBuilder.append(camelCaseArray[1]);
                streetBuilder.append(camelCaseArray[0]);

            } else if (spaceSplitArray.length == 5) {

                String[] digitArray = address.split("(?<=\\D)(?=\\d)");
                houseBuilder.append(digitArray[1]);
                streetBuilder.append(digitArray[0]);


            } else {
                for (int i = 0; i < spaceSplitArray.length; i++) {

                    String value = spaceSplitArray[i];

                    if (Character.isDigit(value.charAt(0)) || Character.isDigit(address.length() - 2)) {
                        houseBuilder.append(spaceSplitArray[i]);
                        houseBuilder.append(" ");

                    } else {
                        streetBuilder.append(spaceSplitArray[i]);
                        streetBuilder.append(" ");

                    }

                }
            }

        }

        houseNumber = houseBuilder.toString();
        street = streetBuilder.toString();

        Address addressResponse = new Address(street.trim(), houseNumber.trim());
        return addressResponse.toString();

    }

}
