package br.org.acal.commons.enumeration;

import br.org.acal.domain.entity.WaterParam;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum WaterQualityParameter {

    APPEARANCE_COLOR("1", "Cor aparente - 15UH"),
    TURBIDITY("2", "Turbidez - 5.0 UT"),
    CHLORINE("3", "Cloro - Min 0,2 mg/l"),
    ESCHERICHIA_COLI("4", "Escherichia Coli"),
    TOTAL_COLIFORMS("5", "Coliformes Totais");

    private final String number;
    private final String description;

    public static WaterParam fromNumber(String number) {
        var item = Arrays.stream(WaterQualityParameter.values()).filter(it -> it.getNumber().equals(number)).findFirst().orElseThrow();
        return  WaterParam.builder().name(item.getDescription()).number(item.getNumber()).build();
    }

    public static WaterParam fromDescription(String description) {
        var item = Arrays.stream(WaterQualityParameter.values()).filter(it -> it.getDescription().equals(description)).findFirst().orElseThrow();
        return WaterParam.builder().name(item.getDescription()).number(item.getNumber()).build();
    }

    public static WaterParam fromEnum(WaterQualityParameter waterQualityParameter) {
        return WaterParam.builder().name(waterQualityParameter.getDescription()).number(waterQualityParameter.getNumber()).build();
    }

}