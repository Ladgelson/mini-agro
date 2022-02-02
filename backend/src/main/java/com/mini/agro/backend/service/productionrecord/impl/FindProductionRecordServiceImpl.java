package com.mini.agro.backend.service.productionrecord.impl;

import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.plot.FindPlotByIdService;
import com.mini.agro.backend.service.productionrecord.FindProductionRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindProductionRecordServiceImpl implements FindProductionRecordService {

    private final ProductionRecordRepository repository;

    private final FindPlotByIdService findPlotByIdService;

    @Override
    public List<ProductionRecord> process(String plotId) {
        Plot plotFound = findPlotByIdService.execute(plotId);
        return (List<ProductionRecord>) repository.findAllById(plotFound.getProductions());
    }
}
