package br.org.acal.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Link {

    private String number;
    private String partnerNumber;
    private Customer customer;
    private Address address;
    private Category category;

}
