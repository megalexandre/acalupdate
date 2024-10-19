package br.org.acal.application.screen.water.hydrometer.model;

import br.org.acal.commons.util.LocalDateUtil;
import br.org.acal.domain.entity.WaterQuality;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static br.org.acal.commons.util.LocalDateTimeUtil.date;

@Data
@Builder
public class WaterQualityTable {

    private String number;
    private String name;
    private String date;
    private String required;
    private String analyzed;
    private String accordance;

    public static WaterQualityTable of(WaterQuality waterQuality){
        return WaterQualityTable.builder()
                .number(waterQuality.getNumber())
                .name(waterQuality.getWaterParam().getName())
                .date(orEmpty(waterQuality.getDate()))
                .required(waterQuality.getRequired())
                .analyzed(waterQuality.getAnalyzed())
                .accordance(waterQuality.getAccordance())
        .build();
    }

    private static String orEmpty(LocalDate value ){
        return value == null ? "" : LocalDateUtil.localDateToString(value);
    }
}
