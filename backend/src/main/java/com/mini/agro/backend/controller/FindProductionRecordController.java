package com.mini.agro.backend.controller;

import com.mini.agro.backend.model.dto.ProductionRecordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "ProductionRecord", description = "Resource to manage data about productions of plots")
@RequestMapping("/v1/plots")
public interface FindProductionRecordController {
    @Operation(description = "Find a list of Production Records")
    @GetMapping("/{id}/production-records")
    ResponseEntity<Page<ProductionRecordDto>> process(
            @ParameterObject @PageableDefault(size = 20, sort = "name") Pageable pageable,
            @PathVariable String id);
}
