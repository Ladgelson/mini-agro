package com.mini.agro.backend.model.entity;

import com.mini.agro.backend.model.entity.base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Farm extends AbstractModel {

    @Indexed(unique = true)
    private String cnpj;

    private String legalName;

    private String tradeName;

    private Address address;

    private List<String> plots = new ArrayList<>();

}
