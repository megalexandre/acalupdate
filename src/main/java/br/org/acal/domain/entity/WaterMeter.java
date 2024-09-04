package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WaterMeter {

    private String number;

    private Double consumptionStart;

    private Double consumptionEnd;

}
