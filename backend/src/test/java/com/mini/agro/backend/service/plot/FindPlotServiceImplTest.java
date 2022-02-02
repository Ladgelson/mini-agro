package com.mini.agro.backend.service.plot;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.repository.PlotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
class FindPlotServiceImplTest {

    @Autowired
    private FindPlotService findPlotService;

    @MockBean
    private FarmRepository farmRepository;

    @MockBean
    private PlotRepository plotRepository;

    private Farm farmMock;

    @BeforeEach
    void setUp() {
        farmMock = FarmMock.createFarm();
        Mockito.when(farmRepository.findById("1"))
                .thenReturn(Optional.of(farmMock));
        Mockito.when(plotRepository.findAllById(any()))
                .thenReturn(List.of(PlotMock.createPlot()));
    }

    @Test
    @DisplayName("Must returns a list of plots of a farm")
    void process() {
        List<Plot> plots = findPlotService.process("1");
        assertEquals(farmMock.getPlots().size(), plots.size());
    }
}