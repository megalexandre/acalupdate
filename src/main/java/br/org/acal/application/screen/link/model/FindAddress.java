package br.org.acal.application.screen.link.model;


import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class FindAddress {

    private Boolean active;



    public Optional<Boolean> getActive(){ return Optional.ofNullable(active);}
}
