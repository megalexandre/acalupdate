package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String number;

    private String type;

    private String name;
    public String getDisplayName(){
        return type + " " + name;
    }
}
