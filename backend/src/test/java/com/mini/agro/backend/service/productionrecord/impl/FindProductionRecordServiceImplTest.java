package com.mini.agro.backend.service.productionrecord.impl;

import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.mock.model.ProductionRecordMock;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.plot.FindPlotByIdService;
import com.mini.agro.backend.service.productionrecord.FindProductionRecordService;
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
class FindProductionRecordServiceImplTest {

    @Autowired
    private FindProductionRecordService findProductionRecordService;

    @MockBean
    private FindPlotByIdService findPlotByIdService;

    @MockBean
    private ProductionRecordRepository productionRecordRepository;

    private Plot plotMock;

    @BeforeEach
    void setUp() {
        plotMock = PlotMock.createPlot();

        Mockito.when(findPlotByIdService.execute("1"))
                .thenReturn(plotMock);

        Mockito.when(productionRecordRepository.findAllById(any()))
                .thenReturn(List.of(ProductionRecordMock.createProductionRecord()));
    }

    @Test
    @DisplayName("Must a valid list of production record")
    void process() {
        List<ProductionRecord> productionRecords = findProductionRecordService.process("1");
        assertEquals(List.of(ProductionRecordMock.createProductionRecord()).size(), productionRecords.size());
    }
}