package com.mini.agro.backend.controller.impl;

import com.mini.agro.backend.controller.SaveFarmController;
import com.mini.agro.backend.mapper.FarmMapper;
import com.mini.agro.backend.model.dto.FarmDto;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.farm.SaveFarmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SaveFarmControllerImpl implements SaveFarmController {

    private final SaveFarmService saveFarmService;

    private final FarmMapper mapper;

    @Override
    public ResponseEntity<FarmDto> process(FarmDto dto) {
        Farm farm = saveFarmService.executeSave(mapper.farmDtoToFarm(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.farmToFarmDto(farm));
    }
}
