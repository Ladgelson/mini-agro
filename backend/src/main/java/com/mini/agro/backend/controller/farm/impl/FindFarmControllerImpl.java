package com.mini.agro.backend.controller.farm.impl;

import com.mini.agro.backend.controller.farm.FindFarmController;
import com.mini.agro.backend.mapper.FarmMapper;
import com.mini.agro.backend.model.dto.FarmDto;
import com.mini.agro.backend.service.farm.FindFarmService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class FindFarmControllerImpl implements FindFarmController {

    private final FindFarmService findFarmService;

    private final FarmMapper mapper;

    @Override
    public ResponseEntity<Page<FarmDto>> process(Pageable pageable) {
        List<FarmDto> farmDtoList = findFarmService
                .execute(pageable)
                .stream()
                .map(mapper::farmToFarmDto)
                .collect(Collectors.toList());
        if(farmDtoList.isEmpty())
            return ResponseEntity.noContent().build();
        Page<FarmDto> response = new PageImpl<>(farmDtoList, pageable, farmDtoList.size());
        return ResponseEntity.ok(response);
    }
}
