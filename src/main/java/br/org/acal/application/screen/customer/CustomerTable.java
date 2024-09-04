package br.org.acal.application.screen.customer;

import br.org.acal.domain.entity.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerTable {

    private String name;
    private String number;
    private String document;
    public static CustomerTable of(Customer customer){
        return CustomerTable.builder()
            .number(customer.getNumber())
            .name(customer.getName())
            .document(customer.getDocument().getNumber())
        .build();
    }

}
