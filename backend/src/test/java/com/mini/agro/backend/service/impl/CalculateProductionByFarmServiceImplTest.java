package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.mock.dto.ProductivityDtoMock;
import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.CalculateProductionByFarmService;
import com.mini.agro.backend.service.CalculateProductionByPlotService;
import com.mini.agro.backend.service.FindFarmByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
class CalculateProductionByFarmServiceImplTest {

    @Autowired
    private CalculateProductionByFarmService calculateProductionByFarmService;

    @MockBean
    private FindFarmByIdService findFarmByIdService;

    @MockBean
    private CalculateProductionByPlotService calculateProductionByPlotService;

    @BeforeEach
    void setUp() {
        Farm farm = FarmMock.createFarm();
        farm.setPlots(List.of(PlotMock.createPlot()));
        Mockito.when(findFarmByIdService.executeSearch("1"))
                .thenReturn(farm);

        Mockito.when(calculateProductionByPlotService.calculateProduction(any()))
                .thenReturn(ProductivityDtoMock.createProductivityDto());
    }

    @Test
    @DisplayName("Must calculate productivity about an entire farm")
    void process() {
        ProductivityDto result = calculateProductionByFarmService.process("1");
        ProductivityDto mock = ProductivityDtoMock.createProductivityDto();
        assertEquals(mock.getArea(), result.getArea());
        assertEquals(mock.getProductivity(), result.getProductivity());
        assertEquals(mock.getTotal(), result.getTotal());
    }
}