package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ProductionRecord extends AbstractModel {

    private Commodity commodity;

    private Long plantsByHectare;

    private Long podsByPlant;

    private Long grainsByPod;

    private Long weightByOneKGrains;

}
