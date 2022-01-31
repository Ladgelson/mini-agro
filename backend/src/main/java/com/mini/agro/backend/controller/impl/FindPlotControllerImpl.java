package com.mini.agro.backend.controller.impl;

import com.mini.agro.backend.controller.FindPlotController;
import com.mini.agro.backend.mapper.PlotMapper;
import com.mini.agro.backend.model.dto.PlotDto;
import com.mini.agro.backend.service.FindPlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class FindPlotControllerImpl implements FindPlotController {

    private final FindPlotService findPlotService;

    private final PlotMapper mapper;

    @Override
    public ResponseEntity<List<PlotDto>> process(String id) {
        List<PlotDto> plots = findPlotService
                .process(id)
                .stream()
                .map(mapper::plotToPlotDto)
                .collect(Collectors.toList());
        if(plots.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(plots);
    }
}
