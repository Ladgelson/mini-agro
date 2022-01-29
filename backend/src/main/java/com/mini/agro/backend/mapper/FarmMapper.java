package com.mini.agro.backend.mapper;

import com.mini.agro.backend.model.dto.FarmDto;
import com.mini.agro.backend.model.entity.Farm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    Farm farmDtoToFarm(FarmDto dto);
    FarmDto farmToFarmDto(Farm farm);
}
