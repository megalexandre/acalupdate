package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Price;
import br.org.acal.resouces.model.PriceModel;

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
