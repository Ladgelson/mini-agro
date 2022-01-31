package com.mini.agro.backend.service.impl;

import com.mini.agro.backend.model.entity.Plot;
import com.mini.agro.backend.service.FindFarmByIdService;
import com.mini.agro.backend.service.FindPlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindPlotServiceImpl implements FindPlotService {

    private final FindFarmByIdService findFarmByIdService;

    @Override
    public List<Plot> process(String farmId) {
        return findFarmByIdService.executeSearch(farmId)
                .getPlots();
    }
}
