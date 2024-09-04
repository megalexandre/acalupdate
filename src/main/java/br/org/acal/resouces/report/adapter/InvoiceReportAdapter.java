package br.org.acal.resouces.report.adapter;

import br.org.acal.domain.entity.Invoice;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

public class InvoiceReportAdapter {

    public JRBeanCollectionDataSource createReport(List<Invoice> invoices){
        return new JRBeanCollectionDataSource(invoices);
    }

}
