package com.mini.agro.backend.mock.dto;

import com.mini.agro.backend.model.dto.ProductivityDto;

import java.math.BigDecimal;

public class ProductivityDtoMock {
    public static ProductivityDto createProductivityDto() {
        return ProductivityDto
                .builder()
                .area(10000L)
                .productivity(BigDecimal.valueOf(20.5))
                .build();
    }
}
