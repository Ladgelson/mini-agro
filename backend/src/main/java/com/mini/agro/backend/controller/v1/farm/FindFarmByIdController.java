package com.mini.agro.backend.controller.v1.farm;

import com.mini.agro.backend.model.dto.FarmDto;
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

@Tag(name = "Farm", description = "Resource to manage data about Farms")
@RequestMapping("/v1/farms")
public interface FindFarmByIdController {
    @Operation(description = "Find a valid Farm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Farm found", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FarmDto.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<FarmDto> process(@PathVariable String id);
}
