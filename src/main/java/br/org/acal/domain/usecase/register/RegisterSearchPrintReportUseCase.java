package br.org.acal.domain.usecase.register;

import br.org.acal.commons.PrintPaths;
import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.commons.util.LocalDateTimeUtil;
import br.org.acal.commons.util.LocalDateUtil;
import br.org.acal.domain.datasource.ReportDataSource;
import br.org.acal.domain.entity.Payment;
import br.org.acal.domain.entity.ReportData;
import br.org.acal.domain.model.PaymentFilter;
import br.org.acal.resouces.model.report.PaymentReport;
import br.org.acal.resouces.print.InvoiceReport;
import lombok.val;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

@Service
public class RegisterSearchPrintReportUseCase {

    private final ReportDataSource reportDataSource;
    private final PaymentPaginateUseCase paymentPaginateUseCase;

    public RegisterSearchPrintReportUseCase(
            ReportDataSource reportDataSource,
            PaymentPaginateUseCase paymentPaginateUseCase
    ){
        this.reportDataSource = reportDataSource;
        this.paymentPaginateUseCase = paymentPaginateUseCase;
    }

    public void execute(PaymentFilter filter) throws JRException {
        val items = paymentPaginateUseCase.execute(filter).stream().map(this::map).toList();
        var report = ReportData.builder()
            .printPaths(PrintPaths.REGISTER)
            .dataSource(new JRBeanCollectionDataSource(items))
            .build();

        reportDataSource.createRegister(report);
    }

    private PaymentReport map(Payment payment){
        return  PaymentReport.builder()
                .number(payment.getNumber())
                .customer(payment.getCustomer())
                .address(payment.getAddress())
                .value(BigDecimalUtil.asString(payment.getValue()))
                .payedValue(payment.getValue())
                .createdAt(LocalDateTimeUtil.localDateToString(payment.getCreatedAt()))
                .build();
    }
}
