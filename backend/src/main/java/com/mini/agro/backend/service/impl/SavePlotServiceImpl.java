package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.service.FindFarmByIdService;
import com.mini.agro.backend.service.SaveFarmService;
import com.mini.agro.backend.service.SavePlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SavePlotServiceImpl implements SavePlotService {

    private final PlotRepository repository;

    private final FindFarmByIdService findFarmByIdService;

    private final SaveFarmService saveFarmService;

    @Override
    @Transactional
    public Plot executeSave(Plot plot, String farmId) {
        Farm farmFound = findFarmByIdService.executeSearch(farmId);
        Plot plotSaved = repository.save(plot);
        farmFound.getPlots().add(plotSaved);
        saveFarmService.executeSave(farmFound);
        return plotSaved;
    }
}
