package com.mini.agro.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String province;

    @NotNull
    private String street;

    @NotNull
    private String zipCode;

    @NotNull
    private int number;

}
