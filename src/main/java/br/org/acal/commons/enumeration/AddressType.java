package br.org.acal.commons.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum AddressType {

    AVENUE("Avenida"),
    FARM("Fazenda"),
    STREET("Rua"),
    SQUARE("Praça"),
    ROAD("Rodovia"),
    ALLEY("Travessa");

    private final String description;

    public static AddressType fromDescription(String description) {
        return Arrays.stream(AddressType.values()).filter(it -> it.description.equals(description)).findFirst().orElseThrow();
    }

}
