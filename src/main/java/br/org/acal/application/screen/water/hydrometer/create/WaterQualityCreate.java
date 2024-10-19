package br.org.acal.application.screen.water.hydrometer.create;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WaterQualityCreate {

    private List<WaterQualityCreateItem> items;

}
