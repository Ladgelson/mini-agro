package com.mini.agro.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;

    private String country;

    private String province;

    private String street;

    private String zipCode;

    private int number;

}
