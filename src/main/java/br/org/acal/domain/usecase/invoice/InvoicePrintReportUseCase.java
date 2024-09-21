package br.org.acal.domain.usecase.invoice;

import br.org.acal.commons.PrintPaths;
import br.org.acal.domain.datasource.ReportDataSource;
import br.org.acal.domain.datasource.WaterQualityDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.ReportData;
import br.org.acal.domain.entity.WaterQuality;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.resouces.print.InvoiceReport;
import lombok.val;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class InvoicePrintReportUseCase {
    private final InvoiceListUseCase invoiceListUseCase;
    private final WaterQualityDataSource waterQualityDataSource;
    private final ReportDataSource reportDataSource;

    public InvoicePrintReportUseCase(
            InvoiceListUseCase invoiceListUseCase,
            WaterQualityDataSource waterQualityDataSource,
            ReportDataSource reportDataSource
    ){
        this.invoiceListUseCase = invoiceListUseCase;
        this.waterQualityDataSource = waterQualityDataSource;
        this.reportDataSource = reportDataSource;
    }

    public void execute(InvoiceFilter invoiceFilter) throws JRException {
        val invoices = invoiceListUseCase.execute(invoiceFilter);

        val period = invoices.stream().map(it -> it.getPeriod().toLocalDate()).toList();
        val waterQuality = waterQualityDataSource.find(period);

        val invoiceReport = invoices.stream().map(
                it -> InvoiceReport.adapter(it, filter(it, waterQuality))
        ).toList();

        var report = ReportData.builder()
            .printPaths(PrintPaths.NEW_INVOICE)
            .dataSource(new JRBeanCollectionDataSource(invoiceReport))
            .build();

        reportDataSource.create(report);
    }

    private Collection<WaterQuality> filter(Invoice invoice, List<WaterQuality> waterQualities) {
        return waterQualities.stream().filter(it -> it.period().equals(invoice.period())).toList();
    }
}
