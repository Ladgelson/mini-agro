package com.mini.agro.backend.repository;

import com.mini.agro.backend.model.entity.ProductionRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRecordRepository extends MongoRepository<ProductionRecord, String> {
}
