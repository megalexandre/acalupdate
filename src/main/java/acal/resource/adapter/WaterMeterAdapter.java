package acal.resource.adapter;

import acal.report.model.WaterMeter;
import acal.resource.model.WaterMeterModel;

import static acal.commons.Coalesce.coalesce;

public class WaterMeterAdapter {

    public static WaterMeter map(WaterMeterModel item){
        if(item == null){
            return null;
        }

        return WaterMeter
                .builder()
                .number(coalesce(item.getNumber(), ""))
                .consumptionStart(coalesce(item.getConsumptionStart(), 0d))
                .consumptionEnd(coalesce(item.getConsumptionEnd(), 0d))
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
