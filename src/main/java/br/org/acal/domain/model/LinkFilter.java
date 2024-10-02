package br.org.acal.domain.model;

import lombok.Builder;
import lombok.Setter;

import java.util.Optional;

@Builder
@Setter
public class LinkFilter {

    private String number;
    private String addressNumber;
    private String categoryNumber;
    private String group;
    private String status;
    private String partner;
    private Boolean isPayed;
    private Boolean active;

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
    public Optional<Boolean> getActive() { return Optional.ofNullable(active);}
    public Optional<Boolean> getIsPayed() { return Optional.ofNullable(isPayed);}

}
