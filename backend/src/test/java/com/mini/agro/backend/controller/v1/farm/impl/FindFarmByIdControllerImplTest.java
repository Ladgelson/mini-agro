package com.mini.agro.backend.controller.v1.farm.impl;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FindFarmByIdControllerImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FindFarmByIdService findFarmByIdService;

    private Farm farmMock;

    private String id;

    @BeforeEach
    void setUp() {
        id = "1";
        farmMock = FarmMock.createFarm();
        Mockito.when(findFarmByIdService.executeSearch(id))
                .thenReturn(farmMock);
    }

    @Test
    @DisplayName("Must returns a valid farm")
    void process() throws Exception {
        mvc.perform(get("/v1/farms/"+id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cnpj").value(farmMock.getCnpj()))
                .andExpect(jsonPath("$.legalName").value(farmMock.getLegalName()))
                .andExpect(jsonPath("$.tradeName").value(farmMock.getTradeName()))
                .andExpect(jsonPath("$.address.city").value(farmMock.getAddress().getCity()))
                .andExpect(jsonPath("$.address.country").value(farmMock.getAddress().getCountry()))
                .andExpect(jsonPath("$.address.province").value(farmMock.getAddress().getProvince()))
                .andExpect(jsonPath("$.address.street").value(farmMock.getAddress().getStreet()))
                .andExpect(jsonPath("$.address.zipCode").value(farmMock.getAddress().getZipCode()))
                .andExpect(jsonPath("$.address.number").value(farmMock.getAddress().getNumber()));
    }
}