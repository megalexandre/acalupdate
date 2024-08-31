package br.org.acal.application.screen.address;

import br.org.acal.domain.model.Address;
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
