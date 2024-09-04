package br.org.acal.resouces.adapter;

import br.org.acal.commons.enumeration.WaterQualityParameter;
import br.org.acal.domain.entity.WaterQuality;
import br.org.acal.resources.model.WaterQualityModel;

public class WaterQualityAdapter {
    public static WaterQuality map(WaterQualityModel item){
        return WaterQuality.builder()
                .waterParam(WaterQualityParameter.fromNumber(item.getParam()))
                .number(item.getNumber())
                .required(item.getRequired())
                .analyzed(item.getAnalyzed())
                .accordance(item.getAccordance())
                .date(item.getDate())
            .build();
    }
}
