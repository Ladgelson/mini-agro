package com.mini.agro.backend.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        address = createAddress();
    }

    @Test
    void setCity() {
        String cityTest = "test";
        address.setCity(cityTest);
        Assertions.assertEquals(Optional.of(cityTest), Optional.ofNullable(address.getCity()));
    }

    @Test
    void setCountry() {
        String countryTest = "test";
        address.setCountry(countryTest);
        Assertions.assertEquals(Optional.of(countryTest), Optional.ofNullable(address.getCountry()));
    }

    @Test
    void setProvince() {
        String provinceTest = "test";
        address.setProvince(provinceTest);
        Assertions.assertEquals(Optional.of(provinceTest), Optional.ofNullable(address.getProvince()));
    }

    @Test
    void setStreet() {
        String streetTest = "test";
        address.setStreet(streetTest);
        Assertions.assertEquals(Optional.of(streetTest), Optional.ofNullable(address.getStreet()));
    }

    @Test
    void setZipCode() {
        String zipCodeTest = "test";
        address.setZipCode(zipCodeTest);
        Assertions.assertEquals(Optional.of(zipCodeTest), Optional.ofNullable(address.getZipCode()));
    }

    @Test
    void setNumber() {
        int numberTest = 1;
        address.setNumber(numberTest);
        Assertions.assertEquals(Optional.of(numberTest), Optional.of(address.getNumber()));
    }

    @Test
    void getCity() {
        Assertions.assertNotNull(address.getCity());
    }

    @Test
    void getCountry() {
        Assertions.assertNotNull(address.getCountry());
    }

    @Test
    void getProvince() {
        Assertions.assertNotNull(address.getProvince());
    }

    @Test
    void getStreet() {
        Assertions.assertNotNull(address.getStreet());
    }

    @Test
    void getZipCode() {
        Assertions.assertNotNull(address.getZipCode());
    }

    @Test
    void getNumber() {
        Assertions.assertEquals(Optional.of(1), Optional.of(address.getNumber()));
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("test");
        address.setCountry("test");
        address.setProvince("test");
        address.setStreet("test");
        address.setZipCode("test");
        address.setNumber(1);
        return address;
    }

}
