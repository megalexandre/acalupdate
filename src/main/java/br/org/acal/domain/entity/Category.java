package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private String number;
    private String name;
    private Price price;

}
