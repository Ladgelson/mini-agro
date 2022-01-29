package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commodity extends AbstractModel {

    private String name;

}
