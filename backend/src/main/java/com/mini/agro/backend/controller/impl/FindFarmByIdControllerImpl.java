package com.mini.agro.backend.controller.impl;

import com.mini.agro.backend.controller.FindFarmByIdController;
import com.mini.agro.backend.mapper.FarmMapper;
import com.mini.agro.backend.model.dto.FarmDto;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.FindFarmByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindFarmByIdControllerImpl implements FindFarmByIdController {

    private final FindFarmByIdService findFarmByIdService;

    private final FarmMapper mapper;

    @Override
    public ResponseEntity<FarmDto> process(String id) {
        Farm farm = findFarmByIdService.executeSearch(id);
        return ResponseEntity.ok(mapper.farmToFarmDto(farm));
    }
}
