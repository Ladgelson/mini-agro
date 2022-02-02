package com.mini.agro.backend.mock.model;

import com.mini.agro.backend.model.entity.Commodity;
import com.mini.agro.backend.model.entity.ProductionRecord;
import com.mini.agro.backend.model.enumeration.TypeCommodity;

import java.math.BigDecimal;

public class ProductionRecordMock {
    public static ProductionRecord createProductionRecord() {
        return ProductionRecord
                .builder()
                .commodity(Commodity
                        .builder()
                        .name("Soja")
                        .typeCommodity(TypeCommodity.GRAIN)
                        .build())
                .grainsByPod(BigDecimal.valueOf(3.4))
                .plantsByHectare(BigDecimal.valueOf(134))
                .weightByOneKGrains(BigDecimal.valueOf(150))
                .podsByPlant(BigDecimal.valueOf(18))
                .build();
    }
}
