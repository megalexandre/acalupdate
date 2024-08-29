package br.org.acal.resouces.adapter;

import br.org.acal.domain.model.WaterQuality;
import br.org.acal.resouces.model.WaterQualityModel;

public interface WaterQualityAdapter {
    WaterQuality map (WaterQualityModel item);
    WaterQualityModel map (WaterQuality item);
}
