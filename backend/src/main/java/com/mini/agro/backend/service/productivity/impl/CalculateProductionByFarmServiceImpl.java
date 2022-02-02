package com.mini.agro.backend.service.productivity.impl;

import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.productivity.CalculateProductionByFarmService;
import com.mini.agro.backend.service.productivity.CalculateProductionByPlotService;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculateProductionByFarmServiceImpl implements CalculateProductionByFarmService {

    private final CalculateProductionByPlotService calculateProductionByPlotService;

    private final FindFarmByIdService findFarmByIdService;

    @Override
    public List<ProductivityDto> process(String farmId) {
        Farm farmFound = findFarmByIdService.executeSearch(farmId);
        return farmFound
                .getPlots()
                .stream()
                .map(calculateProductionByPlotService::calculateProduction)
                .collect(Collectors.toList());
    }
}
