package br.org.acal.domain.model;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import lombok.Builder;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

@Builder
@Setter
public class InvoicePaginate {
    private String startId;
    private String endId;
    private StatusPaymentInvoice status;

    private LocalDateTime createdAtStart;
    private LocalDateTime createdAtEnd;

    private LocalDateTime duoDateStart;
    private LocalDateTime duoDateEnd;

    private Pageable pageable;

    public Optional<Pageable> pageable(){
        return Optional.ofNullable(pageable);
    }

}
