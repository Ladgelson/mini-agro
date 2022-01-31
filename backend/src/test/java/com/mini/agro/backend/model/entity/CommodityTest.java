package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.enumeration.TypeCommodity;
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
    void setTypeCommodity() {
        TypeCommodity typeCommodityTest = TypeCommodity.values()[0];
        commodity.setTypeCommodity(typeCommodityTest);
        Assertions.assertEquals(Optional.of(typeCommodityTest), Optional.ofNullable(commodity.getTypeCommodity()));
    }

    @Test
    void getName() {
        Assertions.assertNotNull(commodity.getName());
    }

    @Test
    void getTypeCommodity() {
        Assertions.assertNotNull(commodity.getTypeCommodity());
    }

    private Commodity createCommodity() {
        Commodity commodity = new Commodity();
        commodity.setName("test");
        commodity.setTypeCommodity(TypeCommodity.values()[0]);
        return commodity;
    }

}
