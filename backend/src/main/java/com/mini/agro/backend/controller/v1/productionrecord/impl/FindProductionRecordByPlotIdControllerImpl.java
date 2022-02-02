package com.mini.agro.backend.controller.v1.productionrecord.impl;

import com.mini.agro.backend.controller.v1.productionrecord.FindProductionRecordByPlotIdController;
import com.mini.agro.backend.mapper.ProductionRecordMapper;
import com.mini.agro.backend.model.dto.ProductionRecordDto;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.service.productionrecord.FindProductionRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class FindProductionRecordByPlotIdControllerImpl implements FindProductionRecordByPlotIdController {

    private final FindProductionRecordService findProductionRecordService;

    private final ProductionRecordMapper mapper;

    @Override
    public ResponseEntity<List<ProductionRecordDto>> process(String id) {
        List<ProductionRecord> productionRecords = findProductionRecordService.process(id);
        if(productionRecords.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(
                productionRecords
                        .stream()
                        .map(mapper::productionRecordToProductionRecordDto)
                        .collect(Collectors.toList()));
    }
}
