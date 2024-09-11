package br.org.acal.application.screen.customer.model;


import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class FindCustomer {

    private Optional<String> document;
    private Optional<String> name;

}
