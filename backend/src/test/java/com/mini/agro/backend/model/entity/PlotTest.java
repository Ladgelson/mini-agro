package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.ProductionRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class PlotTest {

    private Plot plot;

    @BeforeEach
    void setUp() {
        plot = createPlot();
    }

    @Test
    void setArea() {
        Long areaTest = 1L;
        plot.setArea(areaTest);
        Assertions.assertEquals(Optional.of(areaTest), Optional.ofNullable(plot.getArea()));
    }

    @Test
    void setProductions() {
        List<ProductionRecord> productionsTest = List.of();
        plot.setProductions(productionsTest);
        Assertions.assertEquals(Optional.of(productionsTest), Optional.ofNullable(plot.getProductions()));
    }

    @Test
    void getArea() {
        Assertions.assertNotNull(plot.getArea());
    }

    @Test
    void getProductions() {
        Assertions.assertNotNull(plot.getProductions());
    }

    private Plot createPlot() {
        Plot plot = new Plot();
        plot.setArea(1L);
        plot.setProductions(List.of());
        return plot;
    }

}
