package com.mini.agro.backend.service;

import com.mini.agro.backend.model.dto.ProductivityDto;

public interface CalculateProductionByFarmService {
    ProductivityDto process(String farmId);
}
