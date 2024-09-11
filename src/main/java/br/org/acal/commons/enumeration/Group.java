package br.org.acal.commons.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Group {

    FOUNDER("1", "Sócio Fundador"),
    EFFECTIVE("2","Sócio Efetivo"),
    TEMPORARY("3", "Temporario");

    private final String number;
    private final String description;

    public static Group fromDescription(String description) {
        return Arrays.stream(Group.values()).filter(it -> it.description.equals(description)).findFirst().orElseThrow();
    }
    public static Group fromNumber(String description) {
        return Arrays.stream(Group.values()).filter(it -> it.number.equals(description)).findFirst().orElse(
                TEMPORARY
        );
    }
}
