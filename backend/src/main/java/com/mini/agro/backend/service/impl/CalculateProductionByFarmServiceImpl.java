package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.CalculateProductionByFarmService;
import com.mini.agro.backend.service.CalculateProductionByPlotService;
import com.mini.agro.backend.service.FindFarmByIdService;
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
    public ProductivityDto process(String farmId) {
        Farm farmFound = findFarmByIdService.executeSearch(farmId);
        ProductivityDto productivity = new ProductivityDto(new BigDecimal(0), 0L);
        List<ProductivityDto> list = farmFound
                .getPlots()
                .stream()
                .map(plot -> calculateProductionByPlotService.calculateProduction(plot.getId()))
                .collect(Collectors.toList());
        list.forEach(item -> {
            productivity.setProductivity(productivity.getProductivity().add(item.getProductivity()));
            productivity.setArea(productivity.getArea() + item.getArea());
        });
        return productivity;
    }
}
