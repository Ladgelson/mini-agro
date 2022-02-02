package com.mini.agro.backend.service.productionrecord.impl;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.mock.model.ProductionRecordMock;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import com.mini.agro.backend.service.plot.FindPlotByIdService;
import com.mini.agro.backend.service.productionrecord.SaveProductionRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
class SaveProductionRecordServiceImplTest {

    @Autowired
    private SaveProductionRecordService saveProductionRecordService;

    @MockBean
    private FindPlotByIdService findPlotByIdService;

    @MockBean
    private ProductionRecordRepository productionRecordRepository;

    @MockBean
    private PlotRepository plotRepository;

    private ProductionRecord productionRecordMock;

    @BeforeEach
    void setUp() {
        productionRecordMock = ProductionRecordMock.createProductionRecord();
        Mockito.when(findPlotByIdService.execute("1"))
                .thenReturn(PlotMock.createPlot());
        Mockito.when(productionRecordRepository.save(productionRecordMock))
                .thenReturn(productionRecordMock);
        Mockito.when(plotRepository.save(any()))
                .thenReturn(PlotMock.createPlot());
    }

    @Test
    @DisplayName("Must save a valid production record")
    void execute() {
        ProductionRecord productionRecordSaved = saveProductionRecordService.execute(productionRecordMock, "1");
        assertEquals(productionRecordMock.getCommodity(), productionRecordSaved.getCommodity());
        assertEquals(productionRecordMock.getProductivity(), productionRecordSaved.getProductivity());
        assertEquals(productionRecordMock.getGrainsByPod(), productionRecordSaved.getGrainsByPod());
        assertEquals(productionRecordMock.getPlantsByHectare(), productionRecordSaved.getPlantsByHectare());
        assertEquals(productionRecordMock.getPodsByPlant(), productionRecordSaved.getPodsByPlant());
        assertEquals(productionRecordMock.getWeightByOneKGrains(), productionRecordSaved.getWeightByOneKGrains());
    }
}