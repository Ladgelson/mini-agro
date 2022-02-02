package com.mini.agro.backend.service.productionrecord;

import com.mini.agro.backend.model.entity.ProductionRecord;

public interface SaveProductionRecordService {
    ProductionRecord execute(ProductionRecord entity, String plotId);
}
