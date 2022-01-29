package com.mini.agro.backend.controller;

import com.mini.agro.backend.model.dto.FarmDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Farm", description = "Resource to manage data about Farms")
@RequestMapping("/v1/farms")
public interface SaveFarmController {

    @Operation(description = "Create a new Farm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Farm successfully saved", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FarmDto.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping
    ResponseEntity<FarmDto> process(@RequestBody @Validated FarmDto dto);
}
