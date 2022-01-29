package com.mini.agro.backend.mock.dto;

import com.mini.agro.backend.mock.model.AddressMock;
import com.mini.agro.backend.model.dto.FarmDto;

import java.time.Instant;

public class FarmDtoMock {
    public static FarmDto createFarm() {
        return FarmDto
                .builder()
                .id("61f56f25dfb6fc7c6f1a5201")
                .cnpj("12345678948487")
                .address(AddressMock.createAdress())
                .legalName("Fazenda Superior")
                .tradeName("mini-fazenda")
                .createdDate(Instant.now())
                .lastModifiedDate(Instant.now())
                .build();
    }
}
