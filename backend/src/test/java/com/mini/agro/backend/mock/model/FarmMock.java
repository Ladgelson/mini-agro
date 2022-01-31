package com.mini.agro.backend.mock.model;

import com.mini.agro.backend.model.entity.Farm;

import java.util.List;

public class FarmMock {
    public static Farm createFarm() {
        return Farm
                .builder()
                .cnpj("12345678948487")
                .address(AddressMock.createAdress())
                .legalName("Fazenda Superior")
                .tradeName("mini-fazenda")
                .plots(List.of(PlotMock.createPlot()))
                .build();
    }
}
