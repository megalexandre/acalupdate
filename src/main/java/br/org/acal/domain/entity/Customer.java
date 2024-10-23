package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Customer {

    private String number;
    private String name;
    private Document document;
    private String phoneNumber;
    private Boolean active;
    private LocalDate createdAt;
    private String partnerNumber;


}
