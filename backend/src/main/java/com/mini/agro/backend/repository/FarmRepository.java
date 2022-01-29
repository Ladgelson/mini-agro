package com.mini.agro.backend.repository;

import com.mini.agro.backend.model.entity.Farm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends MongoRepository<Farm, String> {
}
