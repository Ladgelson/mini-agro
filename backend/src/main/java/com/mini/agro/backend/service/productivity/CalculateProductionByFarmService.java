package com.mini.agro.backend.service.productivity;

import com.mini.agro.backend.model.dto.ProductivityDto;

import java.util.List;

public interface CalculateProductionByFarmService {
    List<ProductivityDto> process(String farmId);
}
