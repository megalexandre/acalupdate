package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.WaterMeter;
import br.org.acal.resources.model.WaterMeterModel;
import br.org.acal.commons.Coalesce;

public class WaterMeterAdapter {

    public static WaterMeter map(WaterMeterModel item){
        if(item == null){
            return null;
        }

        return WaterMeter
                .builder()
                .number(Coalesce.coalesce(item.getNumber(), ""))
                .consumptionStart(Coalesce.coalesce(item.getConsumptionStart(), 0d))
                .consumptionEnd(Coalesce.coalesce(item.getConsumptionEnd(), 0d))
                .build();
    }

    public static WaterMeterModel map(WaterMeter item){
        if(item == null){
            return null;
        }
        return WaterMeterModel
                .builder()
                .number(item.getNumber())
                .consumptionStart(item.getConsumptionStart())
                .consumptionEnd(item.getConsumptionEnd())
            .build();
    }
}
