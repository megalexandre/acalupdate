package br.org.acal.application.screen.link.model;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Category;
import br.org.acal.domain.entity.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JComboBoxModel {

    private String number;
    private String name;

    public static JComboBoxModel of(Customer customer){
        return JComboBoxModel.builder().
                number(customer.getNumber()).
                name(customer.getName())
                .build();
    }
    public static JComboBoxModel of(Address address){
        return JComboBoxModel.builder().
            number(address.getNumber()).
            name(address.getDisplayName())
        .build();
    }
    public static JComboBoxModel of(Category category){
        return JComboBoxModel.builder().
            number(category.getNumber()).
            name(category.getName())
            .build();
    }


    public static JComboBoxModel clearData(){
        return JComboBoxModel.builder().
            number("").
            name("Selecione")
        .build();
    }

    @Override
    public String toString() {
        return name;
    }

}