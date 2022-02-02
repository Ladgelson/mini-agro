package com.mini.agro.backend.service.productivity;

import com.mini.agro.backend.model.dto.ProductivityDto;

public interface CalculateProductionByPlotService {
    ProductivityDto calculateProduction(String plotId);
}
