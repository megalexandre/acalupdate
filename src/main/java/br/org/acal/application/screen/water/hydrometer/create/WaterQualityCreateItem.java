package br.org.acal.application.screen.water.hydrometer.create;

import br.org.acal.domain.entity.WaterParam;
import br.org.acal.domain.entity.WaterQuality;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WaterQualityCreateItem {

    private WaterParam waterParam;
    private String required;
    private String analyzed;
    private String accordance;
    private LocalDate date;

    public WaterQuality fromWaterQuality(){
        return WaterQuality.builder().waterParam(waterParam).required(required).analyzed(analyzed).accordance(accordance).date(date).build();
    }
}
