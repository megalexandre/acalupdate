package br.org.acal.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Print {

    NEW_INVOICE("/print/acal/invoice.jasper");

    private final String path;

}
