package com.mini.agro.backend.controller.impl;

import com.mini.agro.backend.controller.SaveProductionRecordController;
import com.mini.agro.backend.mapper.ProductionRecordMapper;
import com.mini.agro.backend.model.dto.ProductionRecordDto;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.service.SaveProductionRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SaveProductionRecordControllerImpl implements SaveProductionRecordController {

    private final SaveProductionRecordService saveProductionRecordService;

    private final ProductionRecordMapper mapper;

    @Override
    public ResponseEntity<ProductionRecordDto> process(ProductionRecordDto dto, String id) {
        ProductionRecord entity = saveProductionRecordService
                .execute(mapper.productionRecordDtoToProductionRecord(dto), id);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.productionRecordToProductionRecordDto(entity));
    }
}
