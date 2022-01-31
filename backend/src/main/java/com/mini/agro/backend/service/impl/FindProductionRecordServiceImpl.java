package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import com.mini.agro.backend.service.FindProductionRecordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductionRecordServiceImpl implements FindProductionRecordService {

    private final ProductionRecordRepository repository;

    @Override
    public Page<ProductionRecord> process(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
