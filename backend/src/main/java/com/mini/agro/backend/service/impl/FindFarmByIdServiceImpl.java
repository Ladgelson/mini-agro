package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.service.FindFarmByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindFarmByIdServiceImpl implements FindFarmByIdService {

    private final FarmRepository repository;

    @Override
    public Farm executeSearch(String id) {
        return repository.findById(id).get();
    }
}
