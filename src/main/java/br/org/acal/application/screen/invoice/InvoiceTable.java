package br.org.acal.application.screen.invoice;

import br.org.acal.application.screen.customer.CustomerTable;
import br.org.acal.commons.LocalDateTimeUtil;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Invoice;
import lombok.Builder;
import lombok.Data;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class InvoiceTable {

    private String number;
    private String payedAt;
    private String duoDate;
    private String period;
    private String total;
    private String customer;

    public static InvoiceTable of(Invoice invoice){
        return InvoiceTable.builder()
                .number(invoice.getNumber())
                .payedAt(orEmpty(invoice.getPayedAt(), LocalDateTimeUtil.dateTime))
                .duoDate(LocalDateTimeUtil.date.format(invoice.getDuoDate()))
                .period( invoice.period().asString())
                .total(new DecimalFormat("#,###.##").format(invoice.totalValue()))
                .build();
    }

    private static String orEmpty(LocalDateTime value, DateTimeFormatter formatterPeriod ){
        return value == null ? "" : formatterPeriod.format(value);
    }
}


