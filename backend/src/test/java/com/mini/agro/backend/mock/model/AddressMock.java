package com.mini.agro.backend.mock.model;

import com.mini.agro.backend.model.entity.Address;

public class AddressMock {
    public static Address createAdress() {
        return Address
                .builder()
                .city("Barauna")
                .country("Brasil")
                .number(55)
                .province("Rio Grande do Norte")
                .street("Alto da Avenida")
                .zipCode("59695-000")
                .build();
    }
}
