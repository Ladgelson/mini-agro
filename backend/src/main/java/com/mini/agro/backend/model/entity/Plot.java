package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Plot extends AbstractModel {

    private Long area;

    @DBRef(lazy = true)
    private List<ProductionRecord> productions = new ArrayList<>();

}
