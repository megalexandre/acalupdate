package br.org.acal.resouces.model.report;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentReport {

    private final String number;
    private final String customer;
    private final String address;
    private final String value;
    private final String createdAt;
    private final BigDecimal payedValue;

}
