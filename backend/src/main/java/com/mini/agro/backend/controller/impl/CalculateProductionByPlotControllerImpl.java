package com.mini.agro.backend.controller.impl;

import com.mini.agro.backend.controller.CalculateProductionByPlotController;
import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.service.productivity.CalculateProductionByPlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculateProductionByPlotControllerImpl implements CalculateProductionByPlotController {

    private final CalculateProductionByPlotService calculateProductionByPlotService;

    @Override
    public ResponseEntity<ProductivityDto> process(String id) {
        return ResponseEntity.ok(calculateProductionByPlotService.calculateProduction(id));
    }
}