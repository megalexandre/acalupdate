package br.org.acal.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String number;

    private String type;

    private String name;

}
