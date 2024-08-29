package br.org.acal.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Price {

    private String number;
    private String name;
    private BigDecimal value;
}
