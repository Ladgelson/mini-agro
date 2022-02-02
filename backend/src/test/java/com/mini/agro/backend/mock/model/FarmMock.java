package com.mini.agro.backend.mock.model;

import com.mini.agro.backend.model.entity.Farm;

import java.util.ArrayList;
import java.util.List;

public class FarmMock {
    public static Farm createFarm() {
        return Farm
                .builder()
                .cnpj("12345678948487")
                .address(AddressMock.createAdress())
                .legalName("Fazenda Superior")
                .tradeName("mini-fazenda")
                .plots(new ArrayList<>(List.of("61f6ffd5d7d3c1650890183d")))
                .build();
    }
}
