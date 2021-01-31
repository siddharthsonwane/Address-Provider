package com.main;

import com.service.AddressService;
import com.service.ValidationService;

import java.util.Scanner;
import java.util.logging.Logger;

public class ApplicationMain {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(ApplicationMain.class.getName());

        ValidationService validationService = new ValidationService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the address:");
        String userInput = scanner.nextLine();

        String formattedValue = validationService.validateInput(userInput);

        String response = AddressService.calculateAddress(formattedValue);

        logger.info(response);
    }

}
