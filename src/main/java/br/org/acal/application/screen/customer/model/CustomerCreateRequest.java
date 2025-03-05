package br.org.acal.application.screen.customer.model;


import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Document;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomerCreateRequest {

    @NotEmpty(message =  "Nome é Obrigatório")
    private String name;

    @NotEmpty(message =  "Documento é Obrigatório")
    private String document;

    private String partnerNumber;

    private String phoneNumber;

    private LocalDate createdAt;

    private Boolean isAVoter;

    public Customer toCustomer(){
        return Customer.builder()
                .name(name)
                .document(Document.of(document))
                .phoneNumber(phoneNumber)
                .partnerNumber(partnerNumber)
                .createdAt(createdAt)
                .isAVoter(isAVoter)
                .active(true)
                .build();
    }
}
