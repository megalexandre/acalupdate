package acal.commons;

public enum Report {
    REPORT_INVOICE_DIRECTORY("//report//invoice"),
    NEW_INVOICE("/report/invoice/invoice.jasper"),
    NEW_INVOICE_DETAIL("/report/invoice/invoiceDetail.jasper");

    private final String path;

    Report(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
