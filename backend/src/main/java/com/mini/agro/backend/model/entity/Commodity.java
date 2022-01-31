package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.enumeration.TypeCommodity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commodity {

    private String name;

    private TypeCommodity typeCommodity;

}
