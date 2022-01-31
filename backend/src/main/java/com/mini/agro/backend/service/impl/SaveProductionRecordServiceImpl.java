package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.FindPlotByIdService;
import com.mini.agro.backend.service.SaveProductionRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SaveProductionRecordServiceImpl implements SaveProductionRecordService {

    private final ProductionRecordRepository repository;

    private final FindPlotByIdService findPlotByIdService;

    private final PlotRepository plotRepository;

    @Override
    @Transactional
    public ProductionRecord execute(ProductionRecord entity, String plotId) {
        Plot plotFound = findPlotByIdService.execute(plotId);
        ProductionRecord productionRecordSaved = repository.save(entity);
        plotFound.getProductions().add(productionRecordSaved.getId());
        plotRepository.save(plotFound);
        return productionRecordSaved;
    }
}
