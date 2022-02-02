package com.mini.agro.backend.controller.v1.plot;

import com.mini.agro.backend.model.dto.PlotDto;
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

@Tag(name = "Plot", description = "Resource to manage data about Plots of Farms")
@RequestMapping("/v1/farms")
public interface FindPlotController {
    @Operation(description = "Find a list of Plots")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Plots found", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = PlotDto.class)
                            )
                    )}),
            @ApiResponse(responseCode = "404", description = "Farm not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/plots")
    ResponseEntity<List<PlotDto>> process(@PathVariable String id);
}
