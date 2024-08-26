package acal.report.adapter;

import acal.report.model.Invoice;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

public class InvoiceReportAdapter {

    public JRBeanCollectionDataSource createReport(List<Invoice> invoices){
        return new JRBeanCollectionDataSource(invoices);
    }

}
