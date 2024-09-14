package br.org.acal.resouces.print;

import br.org.acal.domain.entity.WaterQuality;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WaterQualityReport {

    private String waterParam;
    private String required;
    private String analyzed;
    private String accordance;

    public static WaterQualityReport adapter(WaterQuality waterQuality){
        return WaterQualityReport
            .builder()
                .waterParam(waterQuality.getWaterParam().getName())
                .required(waterQuality.getRequired())
                .analyzed(waterQuality.getAnalyzed())
                .accordance(waterQuality.getAccordance())
            .build();
    }

}
