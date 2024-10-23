package br.org.acal.application.screen.customer.model;

import br.org.acal.domain.entity.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerTable {

    private String count;
    private String name;
    private String number;
    private String document;

    public static CustomerTable of(Customer customer, String count){

        return CustomerTable.builder()
            .count(count)
            .number(customer.getNumber())
            .name(customer.getName())
            .document(customer.getDocument().documentNumber())
        .build();
    }

}
