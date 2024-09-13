package br.org.acal.domain.model;

import lombok.Builder;
import lombok.Setter;

import java.util.Optional;

@Builder
@Setter
public class LinkFind {

    private String number;
    private String addressNumber;
    private String categoryNumber;
    private String partner;
    private String group;
    private String status;

    public Optional<String> getNumber() {
        return Optional.ofNullable(number);
    }
    public Optional<String> getAddressNumber() {
        return Optional.ofNullable(addressNumber);
    }
    public Optional<String> getACategoryNumber() {
        return Optional.ofNullable(categoryNumber);
    }
    public Optional<String> getPartner(){
        return Optional.ofNullable(partner);
    }
    public Optional<String> getGroup(){
        return Optional.ofNullable(group);
    }
    public Optional<String> getStatus() { return Optional.ofNullable(status);}

}
