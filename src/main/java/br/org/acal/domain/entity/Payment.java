package br.org.acal.domain.entity;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Payment {

    private final String number;
    private final String customer;
    private final String address;
    private final BigDecimal value;
    private final LocalDateTime createdAt;

}
