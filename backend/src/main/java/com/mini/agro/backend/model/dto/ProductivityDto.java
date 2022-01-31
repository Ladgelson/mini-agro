package com.mini.agro.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
public class ProductivityDto {

    private BigDecimal productivity;

    private Long area;

    public BigDecimal getTotal() {
        return productivity
                .multiply(BigDecimal.valueOf(area)
                        .divide(BigDecimal.valueOf(1000), RoundingMode.HALF_UP));
    }

}
