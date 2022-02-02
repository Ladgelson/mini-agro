package com.mini.agro.backend.service.farm.impl;

import com.mini.agro.backend.mapper.FarmMapper;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.service.farm.FindFarmService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindFarmServiceImpl implements FindFarmService {

    private final FarmRepository repository;

    private final FarmMapper mapper;

    @Override
    public Page<Farm> execute(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
