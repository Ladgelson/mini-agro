package com.mini.agro.backend.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.farm.SaveFarmService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SaveFarmControllerImplTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SaveFarmService saveFarmService;

    private Farm farmMock;

    @BeforeEach
    void setUp() {
        farmMock = FarmMock.createFarm();
        Mockito.when(saveFarmService.executeSave(any()))
                .thenReturn(farmMock);
    }

    @Test
    @DisplayName("Must save a new Farm")
    void process() throws Exception {
        mvc.perform(post("/v1/farms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(farmMock)))
                .andExpect(status().isCreated())
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

    @Test
    @DisplayName("Must throw exception when required field is missing")
    void processWhenRequiredFieldIsMissing() throws Exception {
        farmMock.setCnpj(null);
        mvc.perform(post("/v1/farms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(farmMock)))
                .andExpect(status().isBadRequest());
    }
}