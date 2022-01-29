package com.mini.agro.backend.repository;

import com.mini.agro.backend.model.entity.Commodity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends MongoRepository<Commodity, String> {
}
