package com.mini.agro.backend.service.plot.impl;

import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import com.mini.agro.backend.service.plot.FindPlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindPlotServiceImpl implements FindPlotService {

    private final FindFarmByIdService findFarmByIdService;

    private final PlotRepository plotRepository;

    @Override
    public List<Plot> process(String farmId) {
        Farm farm = findFarmByIdService.executeSearch(farmId);
        return (List<Plot>) plotRepository.findAllById(farm.getPlots());
    }
}
