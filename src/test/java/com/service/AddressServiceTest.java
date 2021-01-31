package com.service;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AddressServiceTest extends TestCase {

    //private AddressService addressService;

    @Before
    public void setUp() throws Exception {
        //this.addressService = addressService;
    }

    @Test
    public void testCalculateAddress_inputOne() {
        String response = AddressService.calculateAddress("Winterallee 3");
        Assert.assertEquals("{\"street\": \"Winterallee\", \"housenumber\": \"3\"}", response);
    }

    @Test
    public void testCalculateAddress_inputTwo() {
        String response = AddressService.calculateAddress("Musterstrasse 45");
        Assert.assertEquals("{\"street\": \"Musterstrasse\", \"housenumber\": \"45\"}", response);
    }

    @Test
    public void testCalculateAddress_inputThree() {
        String response = AddressService.calculateAddress("Blaufeldweg 123B");
        Assert.assertEquals("{\"street\": \"Blaufeldweg\", \"housenumber\": \"123B\"}", response);
    }

    @Test
    public void testCalculateAddress_inputFour() {
        String response = AddressService.calculateAddress("Am Bächle 23");
        Assert.assertEquals("{\"street\": \"Am Bächle\", \"housenumber\": \"23\"}", response);
    }

    @Test
    public void testCalculateAddress_inputFive() {
        String response = AddressService.calculateAddress("Auf der Vogelwiese 23 b");
        Assert.assertEquals("{\"street\": \"Auf der Vogelwiese\", \"housenumber\": \"23 b\"}", response);
    }

    @Test
    public void testCalculateAddress_inputSix() {
        String response = AddressService.calculateAddress("4, rue de la revolution");
        Assert.assertEquals("{\"street\": \"rue de la revolution\", \"housenumber\": \"4\"}", response);
    }

    @Test
    public void testCalculateAddress_inputSeven() {
        String response = AddressService.calculateAddress("200 Broadway Av");
        Assert.assertEquals("{\"street\": \"Broadway Av\", \"housenumber\": \"200\"}", response);
    }

    @Test
    public void testCalculateAddress_inputEight() {
        String response = AddressService.calculateAddress("Calle Aduana, 29");
        Assert.assertEquals("{\"street\": \"Calle Aduana\", \"housenumber\": \"29\"}", response);
    }

    @Test
    public void testCalculateAddress_inputNine() {
        String response = AddressService.calculateAddress("Calle 39 No 1540");
        Assert.assertEquals("{\"street\": \"Calle 39\", \"housenumber\": \"No 1540\"}", response);
    }

}