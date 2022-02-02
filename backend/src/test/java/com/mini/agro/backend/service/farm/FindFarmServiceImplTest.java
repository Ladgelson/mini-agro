package com.mini.agro.backend.service.farm;

import com.mini.agro.backend.mock.model.FarmMock;
import com.mini.agro.backend.model.entity.Farm;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.service.farm.FindFarmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class FindFarmServiceImplTest {

    @Autowired
    private FindFarmService findFarmService;

    @MockBean
    private FarmRepository repository;

    private List<Farm> farmMock = new ArrayList<>();

    @BeforeEach
    void setUp() {
        farmMock.add(FarmMock.createFarm());
        Mockito.when(repository.findAll(Pageable.unpaged()))
                .thenReturn(new PageImpl<>(farmMock, Pageable.unpaged(), farmMock.size()));
    }

    @Test
    @DisplayName("Must a return a list of farms")
    void execute() {
        Page<Farm> farms = findFarmService.execute(Pageable.unpaged());
        assertEquals(farmMock.size(), farms.getTotalElements());
    }
}