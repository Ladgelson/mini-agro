package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.Address;
import com.mini.agro.backend.model.entity.Plot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class FarmTest {

    private Farm farm;

    @BeforeEach
    void setUp() {
        farm = createFarm();
    }

    @Test
    void setCnpj() {
        String cnpjTest = "test";
        farm.setCnpj(cnpjTest);
        Assertions.assertEquals(Optional.of(cnpjTest), Optional.ofNullable(farm.getCnpj()));
    }

    @Test
    void setLegalName() {
        String legalNameTest = "test";
        farm.setLegalName(legalNameTest);
        Assertions.assertEquals(Optional.of(legalNameTest), Optional.ofNullable(farm.getLegalName()));
    }

    @Test
    void setTradeName() {
        String tradeNameTest = "test";
        farm.setTradeName(tradeNameTest);
        Assertions.assertEquals(Optional.of(tradeNameTest), Optional.ofNullable(farm.getTradeName()));
    }

    @Test
    void setAddress() {
        Address addressTest = new Address();
        farm.setAddress(addressTest);
        Assertions.assertEquals(Optional.of(addressTest), Optional.ofNullable(farm.getAddress()));
    }

    @Test
    void setPlots() {
        List<Plot> plotsTest = List.of();
        farm.setPlots(plotsTest);
        Assertions.assertEquals(Optional.of(plotsTest), Optional.ofNullable(farm.getPlots()));
    }

    @Test
    void getCnpj() {
        Assertions.assertNotNull(farm.getCnpj());
    }

    @Test
    void getLegalName() {
        Assertions.assertNotNull(farm.getLegalName());
    }

    @Test
    void getTradeName() {
        Assertions.assertNotNull(farm.getTradeName());
    }

    @Test
    void getAddress() {
        Assertions.assertNotNull(farm.getAddress());
    }

    @Test
    void getPlots() {
        Assertions.assertNotNull(farm.getPlots());
    }

    private Farm createFarm() {
        Farm farm = new Farm();
        farm.setCnpj("test");
        farm.setLegalName("test");
        farm.setTradeName("test");
        farm.setAddress(new Address());
        farm.setPlots(List.of());
        return farm;
    }

}
