package br.org.acal.domain.entity;

import br.org.acal.commons.enumeration.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private String number;
    private String name;
    private Price price;
    private Group group;

}
