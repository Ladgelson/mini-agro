package com.mini.agro.backend.service.plot;

import com.mini.agro.backend.model.entity.Plot;

public interface FindPlotByIdService {
    Plot execute(String id);
}
