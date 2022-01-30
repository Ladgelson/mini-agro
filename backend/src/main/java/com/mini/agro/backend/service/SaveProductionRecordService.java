package com.mini.agro.backend.service;

import com.mini.agro.backend.model.entity.ProductionRecord;

public interface SaveProductionRecordService {
    ProductionRecord execute(ProductionRecord entity, String plotId);
}
