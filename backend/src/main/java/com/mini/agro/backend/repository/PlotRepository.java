package com.mini.agro.backend.repository;

import com.mini.agro.backend.model.entity.Plot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends MongoRepository<Plot, String> {
}
