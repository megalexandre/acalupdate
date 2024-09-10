package br.org.acal.application.screen.customer.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindCustomer {

    private String document;
    private String name;

}
