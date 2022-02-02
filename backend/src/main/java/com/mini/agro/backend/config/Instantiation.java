package com.mini.agro.backend.config;

import com.mini.agro.backend.model.entity.*;
import com.mini.agro.backend.model.enumeration.TypeCommodity;
import com.mini.agro.backend.repository.FarmRepository;
import com.mini.agro.backend.repository.PlotRepository;
import com.mini.agro.backend.repository.ProductionRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final FarmRepository farmRepository;

    private final PlotRepository plotRepository;

    private final ProductionRecordRepository productionRecordRepository;

    @Override
    public void run(String... args) throws Exception {
        farmRepository.deleteAll();
        plotRepository.deleteAll();
        productionRecordRepository.deleteAll();

        Address addressMiniFazenda = Address
                .builder()
                .city("Barauna")
                .country("Brasil")
                .number(55)
                .province("Rio Grande do Norte")
                .street("Alto da Avenida")
                .zipCode("59695-000")
                .build();

        Address address2 = Address
                .builder()
                .city("Fortim")
                .country("Brasil")
                .number(36)
                .province("Ceará")
                .street("Rua Padre José das Cegas")
                .zipCode("529333-000")
                .build();

        Address address3 = Address
                .builder()
                .city("Capibaribe")
                .country("Brasil")
                .number(490)
                .province("Rio Grande do Sul")
                .street("Maloca das Reives")
                .zipCode("45782-000")
                .build();
        Farm minifazenda =Farm
                .builder()
                .cnpj("91.191.062/0001-83")
                .address(addressMiniFazenda)
                .legalName("Fazenda do Zé e do Pereira")
                .tradeName("FarmWire")
                .plots(new ArrayList<>())
                .build();

        Farm bigfazenda =Farm
                .builder()
                .cnpj("90.407.917/0001-06")
                .address(address2)
                .legalName("Fazenda Agricula Famosa")
                .tradeName("Agricket")
                .plots(new ArrayList<>())
                .build();

        Farm fazendinha =Farm
                .builder()
                .cnpj("12.105.541/0001-63")
                .address(address3)
                .legalName("Fazenda Pequena dos Santos")
                .tradeName("FarmGo")
                .plots(new ArrayList<>())
                .build();
        farmRepository.saveAll(Arrays.asList(fazendinha, bigfazenda, minifazenda));

        Plot plot1 = Plot
                .builder()
                .area(10000L)
                .productions(new ArrayList<>())
                .build();
        Plot plot2 = Plot
                .builder()
                .area(20000L)
                .productions(new ArrayList<>())
                .build();
        plotRepository.saveAll(List.of(plot1, plot2));

        minifazenda.getPlots().addAll(List.of(plot1.getId(), plot2.getId()));
        farmRepository.save(minifazenda);

        ProductionRecord productionRecord1 = ProductionRecord
                .builder()
                .commodity(Commodity
                        .builder()
                        .name("Soja")
                        .typeCommodity(TypeCommodity.GRAIN)
                        .build())
                .grainsByPod(BigDecimal.valueOf(3.5))
                .plantsByHectare(BigDecimal.valueOf(60.00))
                .weightByOneKGrains(BigDecimal.valueOf(350.00))
                .podsByPlant(BigDecimal.valueOf(40.0))
                .build();

        ProductionRecord productionRecord2 = ProductionRecord
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

        productionRecordRepository.saveAll(List.of(productionRecord1, productionRecord2));

        plot1.getProductions().addAll(List.of(productionRecord1.getId(), productionRecord2.getId()));
        plot2.getProductions().addAll(List.of(productionRecord2.getId()));

        plotRepository.saveAll(List.of(plot1, plot2));
    }
}
