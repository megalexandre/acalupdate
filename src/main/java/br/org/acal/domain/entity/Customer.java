package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String number;
    private String name;
    private Document document;
    private String phoneNumber;
    private Boolean active;
}
