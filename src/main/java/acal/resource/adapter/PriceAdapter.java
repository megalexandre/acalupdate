package acal.resource.adapter;

import acal.report.model.Price;
import acal.resource.model.CustomerModel;
import acal.resource.model.PriceModel;

public class PriceAdapter {
    public static Price map(PriceModel item){
        return Price
            .builder()
                .number(item.getNumber())
                .name(item.getName())
                .value(item.getValue())
            .build();
    }

    public static PriceModel map(Price item){
        return PriceModel
            .builder()
                .number(item.getNumber())
                .name(item.getName())
                .value(item.getValue())
            .build();

    }
}
