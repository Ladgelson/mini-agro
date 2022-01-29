package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.service.SaveFarmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveFarmServiceImpl implements SaveFarmService {

    private final FarmRepository repository;

    @Override
    public Farm executeSave(Farm farm) {
        return repository.save(farm);
    }
}
