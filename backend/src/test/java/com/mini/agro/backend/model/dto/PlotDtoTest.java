package com.mini.agro.backend.model.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

class PlotDtoTest {

    private PlotDto plotDto;

    @BeforeEach
    void setUp() {
        plotDto = createPlotDto();
    }

    @Test
    void setId() {
        String idTest = "test";
        plotDto.setId(idTest);
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(plotDto.getId()));
    }

    @Test
    void setArea() {
        Long areaTest = 1L;
        plotDto.setArea(areaTest);
        Assertions.assertEquals(Optional.of(areaTest), Optional.ofNullable(plotDto.getArea()));
    }

    @Test
    void setProductions() {
        List<String> productionsTest = List.of();
        plotDto.setProductions(productionsTest);
        Assertions.assertEquals(Optional.of(productionsTest), Optional.ofNullable(plotDto.getProductions()));
    }

    @Test
    void setCreatedDate() {
        Instant createdDateTest = Instant.now();
        plotDto.setCreatedDate(createdDateTest);
        Assertions.assertEquals(Optional.of(createdDateTest), Optional.ofNullable(plotDto.getCreatedDate()));
    }

    @Test
    void setLastModifiedDate() {
        Instant lastModifiedDateTest = Instant.now();
        plotDto.setLastModifiedDate(lastModifiedDateTest);
        Assertions.assertEquals(Optional.of(lastModifiedDateTest), Optional.ofNullable(plotDto.getLastModifiedDate()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(plotDto.getId());
    }

    @Test
    void getArea() {
        Assertions.assertNotNull(plotDto.getArea());
    }

    @Test
    void getProductions() {
        Assertions.assertNotNull(plotDto.getProductions());
    }

    @Test
    void getCreatedDate() {
        Assertions.assertNotNull(plotDto.getCreatedDate());
    }

    @Test
    void getLastModifiedDate() {
        Assertions.assertNotNull(plotDto.getLastModifiedDate());
    }

    private PlotDto createPlotDto() {
        PlotDto plotDto = new PlotDto();
        plotDto.setId("test");
        plotDto.setArea(1L);
        plotDto.setProductions(List.of());
        plotDto.setCreatedDate(Instant.now());
        plotDto.setLastModifiedDate(Instant.now());
        return plotDto;
    }

}
