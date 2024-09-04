package br.org.acal.commons;

public enum Print {
    REPORT_INVOICE_DIRECTORY("//report//invoice"),
    NEW_INVOICE("/print/acal/invoice.jrxml"),
    NEW_INVOICE_DETAIL("/report/invoice/invoiceDetail.jasper");

    private final StringUtil path;

    Print(StringUtil path) {
        this.path = path;
    }

    public StringUtil getPath() {
        return path;
    }
}
