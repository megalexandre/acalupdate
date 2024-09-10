package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Link {

    private String number;
    private String linkNumber;
    private Customer customer;
    private Address address;
    private Category category;

}
