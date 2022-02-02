package com.mini.agro.backend.controller.v1.farm.impl;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.service.farm.FindFarmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FindFarmControllerImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FindFarmService findFarmService;

    private Page<Farm> farmList;

    @BeforeEach
    void setUp() {
        farmList = new PageImpl<>(List.of(FarmMock.createFarm()));
        Mockito.when(findFarmService.execute(any()))
                .thenReturn(farmList);
    }

    @Test
    @DisplayName("Must returns a list of valid farms")
    void process() throws Exception {
        mvc.perform(get("/v1/farms")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Must returns no content status")
    void processWhenNoContent() throws Exception {
        Mockito.when(findFarmService.execute(any()))
                .thenReturn(new PageImpl<>(List.of()));
        mvc.perform(get("/v1/farms")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}