package com.mini.agro.backend.controller;

import com.mini.agro.backend.model.dto.ProductionRecordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "ProductionRecord", description = "Resource to manage data about productions of plots")
@RequestMapping("/v1/plots")
public interface SaveProductionRecordController {
    @Operation(description = "Create a new Production Record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Production Record saved", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductionRecordDto.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/production-records")
    ResponseEntity<ProductionRecordDto> process(@RequestBody @Validated ProductionRecordDto dto, @PathVariable String id);
}
