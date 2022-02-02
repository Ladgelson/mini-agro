package com.mini.agro.backend.service.plot;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import com.mini.agro.backend.service.plot.SavePlotService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
class SavePlotServiceImplTest {

    @Autowired
    private SavePlotService savePlotService;

    @MockBean
    private FindFarmByIdService findFarmByIdService;

    @MockBean
    private PlotRepository plotRepository;

    @MockBean
    private FarmRepository farmRepository;

    private Plot plot;

    @BeforeEach
    void setUp() {
        plot = PlotMock.createPlot();
        Mockito.when(findFarmByIdService.executeSearch("1"))
                .thenReturn(FarmMock.createFarm());
        Mockito.when(plotRepository.save(plot))
                .thenReturn(plot);
        Mockito.when(farmRepository.save(any()))
                .thenReturn(FarmMock.createFarm());

    }

    @Test
    @DisplayName("Must save a valid plot")
    void executeSave() {
        Plot plotSaved = savePlotService.executeSave(plot, "1");
        assertEquals(plot.getArea(), plotSaved.getArea());
        assertEquals(plot.getProductions(), plotSaved.getProductions());
    }
}