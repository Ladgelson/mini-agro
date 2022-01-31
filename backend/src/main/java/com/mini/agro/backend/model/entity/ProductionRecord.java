package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ProductionRecord extends AbstractModel {

    private Commodity commodity;

    private BigDecimal plantsByHectare;

    private BigDecimal podsByPlant;

    private BigDecimal grainsByPod;

    private BigDecimal weightByOneKGrains;

    public BigDecimal getProductivity() {
        BigDecimal staticValue = BigDecimal.valueOf(60000);
        return plantsByHectare
                .multiply(podsByPlant)
                .multiply(grainsByPod)
                .multiply(weightByOneKGrains)
                .divide(staticValue, RoundingMode.HALF_UP)
                .setScale(1, RoundingMode.HALF_UP);
    }

}
