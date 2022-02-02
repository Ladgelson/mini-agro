package com.mini.agro.backend.controller.farm;

import com.mini.agro.backend.model.dto.FarmDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Farm", description = "Resource to manage data about Farms")
@RequestMapping("/v1/farms")
public interface FindFarmController {
    @Operation(description = "Find a list of Farm")
    @GetMapping
    ResponseEntity<Page<FarmDto>> process(@ParameterObject @PageableDefault(size = 20, sort = "name") Pageable pageable);
}
