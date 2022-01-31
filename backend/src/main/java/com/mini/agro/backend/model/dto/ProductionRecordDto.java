package com.mini.agro.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mini.agro.backend.model.entity.Commodity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;

@Data
@NoArgsConstructor
public class ProductionRecordDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;

    @NotNull
    private Commodity commodity;

    @NotNull
    private BigDecimal plantsByHectare;

    @NotNull
    private BigDecimal podsByPlant;

    @NotNull
    private BigDecimal grainsByPod;

    @NotNull
    private BigDecimal weightByOneKGrains;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Instant createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Instant lastModifiedDate;

    public BigDecimal getProductivity() {
        BigDecimal staticValue = BigDecimal.valueOf(60000);
        return plantsByHectare
                .multiply(podsByPlant)
                .multiply(grainsByPod)
                .multiply(weightByOneKGrains)
                .divide(staticValue, RoundingMode.HALF_UP)
                .setScale(1, RoundingMode.HALF_UP);
    }

}
