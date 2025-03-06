package br.org.acal.application.screen.water.hydrometer.model;

import br.org.acal.commons.util.LocalDateUtil;
import br.org.acal.domain.entity.WaterQuality;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WaterQualityTable {

    private String number;
    private String name;
    private String date;
    private String required;
    private String analyzed;
    private String accordance;

    private WaterQuality waterQuality;

    public static WaterQualityTable of(WaterQuality waterQuality){
        return WaterQualityTable.builder()
                .number(waterQuality.getNumber())
                .name(waterQuality.getWaterParam().getName())
                .date(orEmpty(waterQuality.getDate()))
                .required(waterQuality.getRequired())
                .analyzed(waterQuality.getAnalyzed())
                .accordance(waterQuality.getAccordance())
                .waterQuality(waterQuality)
        .build();
    }

    private static String orEmpty(LocalDate value ){
        return value == null ? "" : LocalDateUtil.localDateToString(value);
    }
}
