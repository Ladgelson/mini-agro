package com.mini.agro.backend.mock.model;

import com.mini.agro.backend.model.entity.Plot;

import java.util.List;

public class PlotMock {
    public static Plot createPlot() {
        return Plot
                .builder()
                .area(10000L)
                .productions(List.of("idfakeaqu1"))
                .build();
    }
}
