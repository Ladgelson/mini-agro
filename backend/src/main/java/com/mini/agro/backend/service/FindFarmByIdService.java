package com.mini.agro.backend.service;

import com.mini.agro.backend.model.entity.Farm;

public interface FindFarmByIdService {
    Farm executeSearch(String id);
}
