package com.mini.agro.backend.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class CommodityTest {

    private Commodity commodity;

    @BeforeEach
    void setUp() {
        commodity = createCommodity();
    }

    @Test
    void setName() {
        String nameTest = "test";
        commodity.setName(nameTest);
        Assertions.assertEquals(Optional.of(nameTest), Optional.ofNullable(commodity.getName()));
    }

    @Test
    void getName() {
        Assertions.assertNotNull(commodity.getName());
    }

    private Commodity createCommodity() {
        Commodity commodity = new Commodity();
        commodity.setName("test");
        return commodity;
    }

}
