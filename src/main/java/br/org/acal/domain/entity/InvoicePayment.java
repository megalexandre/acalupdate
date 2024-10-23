package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InvoicePayment {

    private String number;
    private LocalDateTime payedAt;

}
