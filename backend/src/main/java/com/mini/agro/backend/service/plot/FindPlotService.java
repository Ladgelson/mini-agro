package com.mini.agro.backend.service.plot;

import com.mini.agro.backend.model.entity.Plot;

import java.util.List;

public interface FindPlotService {
    List<Plot> process(String farmId);
}
