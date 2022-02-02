package com.mini.agro.backend.service.farm;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class SaveFarmServiceImplTest {

    @Autowired
    private SaveFarmService saveFarmService;

    @MockBean
    private FarmRepository repository;

    private Farm farmMock;

    @BeforeEach
    void setUp() {
        farmMock = FarmMock.createFarm();
        when(repository.save(farmMock))
                .thenReturn(farmMock);
    }

    @Test
    @DisplayName("Must save a new Farm")
    void executeSave() {
        Farm farm = saveFarmService.executeSave(farmMock);
        assertEquals(farmMock.getAddress(), farm.getAddress());
        assertEquals(farmMock.getCnpj(), farm.getCnpj());
        assertEquals(farmMock.getPlots(), farm.getPlots());
        assertEquals(farmMock.getLegalName(), farm.getLegalName());
        assertEquals(farmMock.getTradeName(), farm.getTradeName());
    }
}