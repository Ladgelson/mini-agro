package com.mini.agro.backend.service.farm;

import com.mini.agro.backend.model.entity.Farm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindFarmService {
    Page<Farm> execute(Pageable pageable);
}
