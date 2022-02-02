package com.mini.agro.backend.controller.plot.impl;

import com.mini.agro.backend.controller.plot.SavePlotController;
import com.mini.agro.backend.mapper.PlotMapper;
import com.mini.agro.backend.model.dto.PlotDto;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.service.plot.SavePlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SavePlotControllerImpl implements SavePlotController {

    private final SavePlotService savePlotService;

    private final PlotMapper mapper;

    @Override
    public ResponseEntity<PlotDto> executeSave(PlotDto dto, String id) {
        Plot plotSaved = savePlotService.executeSave(mapper.plotDtoToPlot(dto), id);
        return ResponseEntity.ok(mapper.plotToPlotDto(plotSaved));
    }
}
