package com.mini.agro.backend.service.plot;

import com.mini.agro.backend.mock.model.PlotMock;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.service.plot.FindPlotByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class FindPlotByIdServiceImplTest {

    @Autowired
    private FindPlotByIdService findPlotByIdService;

    @MockBean
    private PlotRepository plotRepository;

    private Plot plotMock;

    @BeforeEach
    void setUp() {
        plotMock = PlotMock.createPlot();
        Mockito.when(plotRepository.findById("1"))
                .thenReturn(Optional.of(plotMock));
    }

    @Test
    @DisplayName("Must find a valid plot on the database")
    void execute() {
        Plot plot = findPlotByIdService.execute("1");
        assertEquals(plotMock.getProductions(), plot.getProductions());
        assertEquals(plotMock.getArea(), plot.getArea());
    }
}