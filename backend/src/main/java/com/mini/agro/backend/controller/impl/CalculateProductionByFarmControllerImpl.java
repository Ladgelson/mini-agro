package com.mini.agro.backend.controller.impl;

import com.mini.agro.backend.controller.CalculateProductionByFarmController;
import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.service.productivity.CalculateProductionByFarmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CalculateProductionByFarmControllerImpl implements CalculateProductionByFarmController {

    private final CalculateProductionByFarmService calculateProductionByFarmService;

    @Override
    public ResponseEntity<List<ProductivityDto>> process(String id) {
        return ResponseEntity.ok(calculateProductionByFarmService.process(id));
    }
}
