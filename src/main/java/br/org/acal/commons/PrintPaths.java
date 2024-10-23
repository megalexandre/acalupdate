package br.org.acal.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PrintPaths {

    NEW_INVOICE("invoice.jrxml"),
    REGISTER("register.jrxml");

    private final String path;

}
