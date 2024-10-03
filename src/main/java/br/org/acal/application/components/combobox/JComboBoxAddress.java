package br.org.acal.application.components.combobox;

import br.org.acal.domain.entity.Address;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class JComboBoxAddress extends JComboBoxDefault {

    private String number;
    private String name;
    private Address address;

    public static JComboBoxAddress of(Address address){
        return JComboBoxAddress.builder()
            .address(address)
            .number(address.getNumber())
            .name(address.getDisplayName())
        .build();
    }

    public static JComboBoxAddress select(){
        return JComboBoxAddress.builder().
                number(EMPTY).
                name(SELECT)
                .build();
    }

    @Override
    public String toString() {
        return name;
    }

}