package acal.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FindInvoice {
    private String startId;
    private String endId;
    private StatusPaymentInvoice status;

    private LocalDateTime createdAtStart;
    private LocalDateTime createdAtEnd;

    private LocalDateTime duoDateStart;
    private LocalDateTime duoDateEnd;

    private String categoria;
    private String customerId;
    private String logradouro;
    private Boolean socioExclusivo;
}

