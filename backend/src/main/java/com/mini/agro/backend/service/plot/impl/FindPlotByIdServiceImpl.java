package com.mini.agro.backend.service.plot.impl;

import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.service.plot.FindPlotByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class FindPlotByIdServiceImpl implements FindPlotByIdService {

    private final PlotRepository repository;

    @Override
    public Plot execute(String id) {
        return repository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plot not found", null));
    }
}
