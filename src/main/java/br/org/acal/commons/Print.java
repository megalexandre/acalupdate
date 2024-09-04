package br.org.acal.commons;

import lombok.Getter;

@Getter
public enum Print {
    REPORT_INVOICE_DIRECTORY("//report//invoice"),
    NEW_INVOICE("/print/acal/invoice.jrxml"),
    NEW_INVOICE_DETAIL("/report/invoice/invoiceDetail.jasper");

    private final String path;

    Print(String path) {
        this.path = path;
    }

}
