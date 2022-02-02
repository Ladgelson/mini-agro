package com.mini.agro.backend.service.plot;

import com.mini.agro.backend.model.entity.Plot;

public interface SavePlotService {
    Plot executeSave(Plot plot, String farmId);
}
