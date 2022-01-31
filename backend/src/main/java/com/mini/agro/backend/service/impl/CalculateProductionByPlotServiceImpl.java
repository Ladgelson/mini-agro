package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.dto.ProductivityDto;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.CalculateProductionByPlotService;
import com.mini.agro.backend.service.FindPlotByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CalculateProductionByPlotServiceImpl implements CalculateProductionByPlotService {

    private final FindPlotByIdService findPlotByIdService;

    private final ProductionRecordRepository productionRecordRepository;

    @Override
    public ProductivityDto calculateProduction(String plotId) {
        Plot plot = findPlotByIdService.execute(plotId);
        ProductivityDto result = new ProductivityDto(BigDecimal.valueOf(0), plot.getArea());
        List<ProductionRecord> productionRecords = (List<ProductionRecord>) productionRecordRepository.findAllById(plot.getProductions());
        productionRecords.forEach(productionRecord -> {
            result.setArea(plot.getArea());
            result.setProductivity(result.getProductivity().add(productionRecord.getProductivity()));
        });
        return result;
    }
}
