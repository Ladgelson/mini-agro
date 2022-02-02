package com.mini.agro.backend.controller.plot;

import com.mini.agro.backend.model.dto.PlotDto;
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

@Tag(name = "Plot", description = "Resource to manage data about Plots of Farms")
@RequestMapping("/v1/farms")
public interface SavePlotController {
    @Operation(description = "Create a new Plot")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plot successfully saved", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PlotDto.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/plots")
    ResponseEntity<PlotDto> executeSave(@RequestBody @Validated PlotDto plotDto, @PathVariable String id);
}
