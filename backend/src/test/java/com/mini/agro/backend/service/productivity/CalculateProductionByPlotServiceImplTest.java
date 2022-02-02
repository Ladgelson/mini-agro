package com.mini.agro.backend.service.productivity;

import com.mini.agro.backend.mock.dto.ProductivityDtoMock;
import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.mock.model.ProductionRecordMock;
import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.productivity.CalculateProductionByPlotService;
import com.mini.agro.backend.service.plot.FindPlotByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class CalculateProductionByPlotServiceImplTest {

    @Autowired
    private CalculateProductionByPlotService calculateProductionByPlotService;

    @MockBean
    private FindPlotByIdService findPlotByIdService;

    @MockBean
    private ProductionRecordRepository productionRecordRepository;

    @BeforeEach
    void setUp() {
        Plot plot = PlotMock.createPlot();
        Mockito.when(findPlotByIdService.execute("1"))
                .thenReturn(plot);

        Mockito.when(productionRecordRepository.findAllById(List.of(plot.getProductions().get(0))))
                .thenReturn(List.of(ProductionRecordMock.createProductionRecord()));
    }

    @Test
    @DisplayName("Must calculate productivity about a plot")
    void process() {
        ProductivityDto result = calculateProductionByPlotService.calculateProduction("1");
        ProductivityDto mock = ProductivityDtoMock.createProductivityDto();
        assertEquals(mock.getArea(), result.getArea());
        assertEquals(mock.getProductivity(), result.getProductivity());
        assertEquals(mock.getTotal(), result.getTotal());
    }
}