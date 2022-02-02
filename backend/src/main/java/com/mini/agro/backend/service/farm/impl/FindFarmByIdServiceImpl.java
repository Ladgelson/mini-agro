package com.mini.agro.backend.service.farm.impl;

import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class FindFarmByIdServiceImpl implements FindFarmByIdService {

    private final FarmRepository repository;

    @Override
    public Farm executeSearch(String id) {
        return repository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Farm not found", null));
    }
}
