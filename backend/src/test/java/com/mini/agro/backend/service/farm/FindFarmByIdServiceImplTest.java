package com.mini.agro.backend.service.farm;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.service.farm.FindFarmByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class FindFarmByIdServiceImplTest {

    @Autowired
    private FindFarmByIdService findFarmByIdService;

    @MockBean
    private FarmRepository repository;

    private Farm farmMock;

    @BeforeEach
    void setUp() {
        farmMock = FarmMock.createFarm();
        Mockito.when(repository.findById("1"))
                .thenReturn(Optional.of(farmMock));
    }

    @Test
    @DisplayName("Must returns an existent Farm")
    void executeSearch() {
        Farm foundFarm = findFarmByIdService.executeSearch("1");
        assertEquals(farmMock.getAddress(), foundFarm.getAddress());
        assertEquals(farmMock.getCnpj(), foundFarm.getCnpj());
        assertEquals(farmMock.getPlots(), foundFarm.getPlots());
        assertEquals(farmMock.getLegalName(), foundFarm.getLegalName());
        assertEquals(farmMock.getTradeName(), foundFarm.getTradeName());
    }
}