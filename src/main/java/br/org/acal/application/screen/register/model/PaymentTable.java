package br.org.acal.application.screen.register.model;

import br.org.acal.domain.entity.Payment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static br.org.acal.commons.util.LocalDateTimeUtil.date;
import static br.org.acal.commons.util.MoneyUtil.currency;

@Data
@Builder
public class PaymentTable {

    private String number;
    private String address;
    private String customer;
    private String createdAt;
    private String value;

    public static PaymentTable of(Payment payment){
        return PaymentTable.builder()
                .customer(payment.getCustomer())
                .address(payment.getAddress())
                .number(payment.getNumber())
                .value(currency.format(payment.getValue()))
                .createdAt(orEmpty(payment.getCreatedAt()))
                .build();
    }

    private static String orEmpty(LocalDateTime value ){
        return value == null ? "" : date.format(value);
    }

}


