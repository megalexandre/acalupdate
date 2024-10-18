package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.val;

@Data
@Builder
public class WaterMeter {

    private String number;

    private String InvoiceNumber;

    private Double consumptionStart;

    private Double consumptionEnd;

    public Double total(){
        val start = consumptionStart == null ? 0.0 : consumptionStart;
        val end = consumptionEnd == null ? 0.0: consumptionEnd;
        return start - end;
    }

}
