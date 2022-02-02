package com.mini.agro.backend.service.productionrecord;

import com.mini.agro.backend.model.entity.ProductionRecord;

import java.util.List;

public interface FindProductionRecordService {
    List<ProductionRecord> process(String plotId);
}
