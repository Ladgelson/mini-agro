package com.mini.agro.backend.mapper;

import com.mini.agro.backend.model.dto.PlotDto;
import com.mini.agro.backend.model.entity.Plot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlotMapper {
    Plot plotDtoToPlot(PlotDto dto);
    PlotDto plotToPlotDto(Plot plot);
}
