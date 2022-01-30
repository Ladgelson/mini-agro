package com.mini.agro.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mini.agro.backend.model.entity.Commodity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionRecordDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;

    @NotNull
    private Commodity commodity;

    @NotNull
    private Long plantsByHectare;

    @NotNull
    private Long podsByPlant;

    @NotNull
    private Long grainsByPod;

    @NotNull
    private Long weightByOneKGrains;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Instant createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Instant lastModifiedDate;


}
