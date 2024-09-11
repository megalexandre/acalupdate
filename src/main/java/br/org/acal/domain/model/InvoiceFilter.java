package br.org.acal.domain.model;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceFilter {
    private String startId;
    private String endId;
    private StatusPaymentInvoice status;

    private LocalDateTime createdAtStart;
    private LocalDateTime createdAtEnd;

    private LocalDateTime duoDateStart;
    private LocalDateTime duoDateEnd;


}

