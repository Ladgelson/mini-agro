package com.mini.agro.backend.model.dto;

import com.mini.agro.backend.model.entity.Commodity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

class ProductionRecordDtoTest {

    private ProductionRecordDto productionRecordDto;

    @BeforeEach
    void setUp() {
        productionRecordDto = createProductionRecordDto();
    }

    @Test
    void setId() {
        String idTest = "test";
        productionRecordDto.setId(idTest);
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(productionRecordDto.getId()));
    }

    @Test
    void setCommodity() {
        Commodity commodityTest = new Commodity();
        productionRecordDto.setCommodity(commodityTest);
        Assertions.assertEquals(Optional.of(commodityTest), Optional.ofNullable(productionRecordDto.getCommodity()));
    }

    @Test
    void setPlantsByHectare() {
        BigDecimal plantsByHectareTest = BigDecimal.valueOf(1);
        productionRecordDto.setPlantsByHectare(plantsByHectareTest);
        Assertions.assertEquals(Optional.of(plantsByHectareTest), Optional.ofNullable(productionRecordDto.getPlantsByHectare()));
    }

    @Test
    void setPodsByPlant() {
        BigDecimal podsByPlantTest = BigDecimal.valueOf(1);
        productionRecordDto.setPodsByPlant(podsByPlantTest);
        Assertions.assertEquals(Optional.of(podsByPlantTest), Optional.ofNullable(productionRecordDto.getPodsByPlant()));
    }

    @Test
    void setGrainsByPod() {
        BigDecimal grainsByPodTest = BigDecimal.valueOf(1);
        productionRecordDto.setGrainsByPod(grainsByPodTest);
        Assertions.assertEquals(Optional.of(grainsByPodTest), Optional.ofNullable(productionRecordDto.getGrainsByPod()));
    }

    @Test
    void setWeightByOneKGrains() {
        BigDecimal weightByOneKGrainsTest = BigDecimal.valueOf(1);
        productionRecordDto.setWeightByOneKGrains(weightByOneKGrainsTest);
        Assertions.assertEquals(Optional.of(weightByOneKGrainsTest), Optional.ofNullable(productionRecordDto.getWeightByOneKGrains()));
    }

    @Test
    void setCreatedDate() {
        Instant createdDateTest = Instant.now();
        productionRecordDto.setCreatedDate(createdDateTest);
        Assertions.assertEquals(Optional.of(createdDateTest), Optional.ofNullable(productionRecordDto.getCreatedDate()));
    }

    @Test
    void setLastModifiedDate() {
        Instant lastModifiedDateTest = Instant.now();
        productionRecordDto.setLastModifiedDate(lastModifiedDateTest);
        Assertions.assertEquals(Optional.of(lastModifiedDateTest), Optional.ofNullable(productionRecordDto.getLastModifiedDate()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(productionRecordDto.getId());
    }

    @Test
    void getCommodity() {
        Assertions.assertNotNull(productionRecordDto.getCommodity());
    }

    @Test
    void getPlantsByHectare() {
        Assertions.assertNotNull(productionRecordDto.getPlantsByHectare());
    }

    @Test
    void getPodsByPlant() {
        Assertions.assertNotNull(productionRecordDto.getPodsByPlant());
    }

    @Test
    void getGrainsByPod() {
        Assertions.assertNotNull(productionRecordDto.getGrainsByPod());
    }

    @Test
    void getWeightByOneKGrains() {
        Assertions.assertNotNull(productionRecordDto.getWeightByOneKGrains());
    }

    @Test
    void getCreatedDate() {
        Assertions.assertNotNull(productionRecordDto.getCreatedDate());
    }

    @Test
    void getLastModifiedDate() {
        Assertions.assertNotNull(productionRecordDto.getLastModifiedDate());
    }

    private ProductionRecordDto createProductionRecordDto() {
        ProductionRecordDto productionRecordDto = new ProductionRecordDto();
        productionRecordDto.setId("test");
        productionRecordDto.setCommodity(new Commodity());
        productionRecordDto.setPlantsByHectare(BigDecimal.valueOf(1));
        productionRecordDto.setPodsByPlant(BigDecimal.valueOf(1));
        productionRecordDto.setGrainsByPod(BigDecimal.valueOf(1));
        productionRecordDto.setWeightByOneKGrains(BigDecimal.valueOf(1));
        productionRecordDto.setCreatedDate(Instant.now());
        productionRecordDto.setLastModifiedDate(Instant.now());
        return productionRecordDto;
    }

}
