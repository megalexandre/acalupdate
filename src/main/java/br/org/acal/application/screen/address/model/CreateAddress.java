package br.org.acal.application.screen.address.model;

import br.org.acal.domain.entity.Address;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class CreateAddress {

    private String type;
    private String name;

    public Address toAddress(){
        return Address.builder().name(name).type(type).build();
    }

    public boolean isValid() {
        return isNotNullOrBlank(type) && isNotNullOrBlank(name);
    }

    private boolean isNotNullOrBlank(String value) {
        return Objects.nonNull(value) && !value.isBlank();
    }
}
