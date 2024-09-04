package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Address;
import br.org.acal.resouces.model.AddressModel;

public class AddressAdapter {

    public static Address map(AddressModel item){
        return Address
            .builder()
                .name(item.getName())
                .type(item.getType())
                .number(item.getNumber())
            .build();
    }

    public static AddressModel map(Address item){
        return AddressModel
            .builder()
                .name(item.getName())
                .type(item.getType())
                .number(item.getNumber())
            .build();

    }
}
