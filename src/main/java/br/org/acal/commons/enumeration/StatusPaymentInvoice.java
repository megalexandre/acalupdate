package br.org.acal.commons.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusPaymentInvoice {

    OPEN("Aberta"),
    OVERDUE("Atrasada"),
    PAYED("Paga");

    private final String description;

    public static StatusPaymentInvoice fromDescription(String description) {
        return Arrays.stream(StatusPaymentInvoice.values()).filter(it -> it.description.equals(description)).findFirst().orElseThrow();
    }
}
