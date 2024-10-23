package br.org.acal.application.screen.customer.model;


import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class FindCustomer {

    private String id;
    private String document;
    private String partnerNumber;
    private String name;
    private Boolean active;

    public Optional<String> getId(){
        return Optional.ofNullable(id);
    }
    public Optional<String> getDocument(){
        return Optional.ofNullable(document);
    }
    public Optional<String> getPartnerNumber(){ return Optional.ofNullable(partnerNumber);}
    public Optional<String> getName(){
        return Optional.ofNullable(name);
    }
    public Optional<Boolean> getActive(){ return Optional.ofNullable(active);}
}
