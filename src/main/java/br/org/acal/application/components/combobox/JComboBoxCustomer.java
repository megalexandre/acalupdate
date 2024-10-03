package br.org.acal.application.components.combobox;

import br.org.acal.domain.entity.Customer;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class JComboBoxCustomer extends JComboBoxDefault {

    private String number;
    private String name;
    private Customer customer;

    public static JComboBoxCustomer of(Customer customer){
        return JComboBoxCustomer.builder()
            .customer(customer)
            .number(customer.getNumber())
            .name(customer.getName())
            .build();
    }

    public static JComboBoxCustomer clearData(){
        return JComboBoxCustomer.builder().
            number(EMPTY).
            name(SELECT)
        .build();
    }

    @Override
    public String toString() {
        return name;
    }

}