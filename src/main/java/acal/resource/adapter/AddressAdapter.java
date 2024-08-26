package acal.resource.adapter;

import acal.report.model.Address;
import acal.resource.model.AddressModel;

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
