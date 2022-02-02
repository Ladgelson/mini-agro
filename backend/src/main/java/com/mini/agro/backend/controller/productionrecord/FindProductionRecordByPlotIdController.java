package com.mini.agro.backend.controller.productionrecord;

import com.mini.agro.backend.model.dto.ProductionRecordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "ProductionRecord", description = "Resource to manage data about productions of plots")
@RequestMapping("/v1/plots")
public interface FindProductionRecordByPlotIdController {
    @Operation(description = "Find a list of Production Records")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Production Records found", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = ProductionRecordDto.class)
                            )
                    )}),
            @ApiResponse(responseCode = "204", description = "No one Production Record found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Plot not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/production-records")
    ResponseEntity<List<ProductionRecordDto>> process(@PathVariable String id);
}
