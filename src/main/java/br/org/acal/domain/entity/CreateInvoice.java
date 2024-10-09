package br.org.acal.domain.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateInvoice {

    private Invoice invoice;
    private Link link;

}
