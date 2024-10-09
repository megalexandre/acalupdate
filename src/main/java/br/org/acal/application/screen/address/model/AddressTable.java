package br.org.acal.application.screen.address.model;

import br.org.acal.domain.entity.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressTable {

    private String number;
    private String name;
    public static AddressTable of(Address address){
        return AddressTable.builder().number(address.getNumber()).name(address.getType().trim() +" "+ address.getName().trim()).build();
    }

}
