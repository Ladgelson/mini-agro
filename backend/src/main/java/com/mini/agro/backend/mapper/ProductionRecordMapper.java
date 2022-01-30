package com.mini.agro.backend.mapper;

import com.mini.agro.backend.model.dto.ProductionRecordDto;
import com.mini.agro.backend.model.entity.ProductionRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductionRecordMapper {
    ProductionRecord productionRecordDtoToProductionRecord(ProductionRecordDto dto);
    ProductionRecordDto productionRecordToProductionRecordDto(ProductionRecord entity);
}
