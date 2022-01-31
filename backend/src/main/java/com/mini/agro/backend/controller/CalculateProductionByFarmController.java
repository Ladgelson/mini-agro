package com.mini.agro.backend.controller;

import com.mini.agro.backend.model.dto.ProductivityDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Productivity", description = "Calculate the productivity about a domain")
@RequestMapping("/v1/farms")
public interface CalculateProductionByFarmController {
    @Operation(description = "Calculate a productivity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productivity calculated by Farm", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductivityDto.class)
                    )}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/productivity")
    ResponseEntity<ProductivityDto> process(@PathVariable String id);
}
