package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.Commodity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class ProductionRecordTest {

    private ProductionRecord productionRecord;

    @BeforeEach
    void setUp() {
        productionRecord = createProductionRecord();
    }

    @Test
    void setCommodity() {
        Commodity commodityTest = new Commodity();
        productionRecord.setCommodity(commodityTest);
        Assertions.assertEquals(Optional.of(commodityTest), Optional.ofNullable(productionRecord.getCommodity()));
    }

    @Test
    void setPlantsByHectare() {
        Long plantsByHectareTest = 1L;
        productionRecord.setPlantsByHectare(plantsByHectareTest);
        Assertions.assertEquals(Optional.of(plantsByHectareTest), Optional.ofNullable(productionRecord.getPlantsByHectare()));
    }

    @Test
    void setPodsByPlant() {
        Long podsByPlantTest = 1L;
        productionRecord.setPodsByPlant(podsByPlantTest);
        Assertions.assertEquals(Optional.of(podsByPlantTest), Optional.ofNullable(productionRecord.getPodsByPlant()));
    }

    @Test
    void setGrainsByPod() {
        Long grainsByPodTest = 1L;
        productionRecord.setGrainsByPod(grainsByPodTest);
        Assertions.assertEquals(Optional.of(grainsByPodTest), Optional.ofNullable(productionRecord.getGrainsByPod()));
    }

    @Test
    void setWeightByOneKGrains() {
        Long weightByOneKGrainsTest = 1L;
        productionRecord.setWeightByOneKGrains(weightByOneKGrainsTest);
        Assertions.assertEquals(Optional.of(weightByOneKGrainsTest), Optional.ofNullable(productionRecord.getWeightByOneKGrains()));
    }

    @Test
    void getCommodity() {
        Assertions.assertNotNull(productionRecord.getCommodity());
    }

    @Test
    void getPlantsByHectare() {
        Assertions.assertNotNull(productionRecord.getPlantsByHectare());
    }

    @Test
    void getPodsByPlant() {
        Assertions.assertNotNull(productionRecord.getPodsByPlant());
    }

    @Test
    void getGrainsByPod() {
        Assertions.assertNotNull(productionRecord.getGrainsByPod());
    }

    @Test
    void getWeightByOneKGrains() {
        Assertions.assertNotNull(productionRecord.getWeightByOneKGrains());
    }

    private ProductionRecord createProductionRecord() {
        ProductionRecord productionRecord = new ProductionRecord();
        productionRecord.setCommodity(new Commodity());
        productionRecord.setPlantsByHectare(1L);
        productionRecord.setPodsByPlant(1L);
        productionRecord.setGrainsByPod(1L);
        productionRecord.setWeightByOneKGrains(1L);
        return productionRecord;
    }

}
