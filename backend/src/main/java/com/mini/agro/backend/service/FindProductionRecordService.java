package com.mini.agro.backend.service;

import com.mini.agro.backend.model.entity.ProductionRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProductionRecordService {
    Page<ProductionRecord> process(Pageable pageable);
}
