package br.org.acal.application.screen.invoice.model.table;

import br.org.acal.commons.util.PeriodUtil;
import br.org.acal.domain.entity.Invoice;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static br.org.acal.commons.util.LocalDateTimeUtil.date;
import static br.org.acal.commons.util.MoneyUtil.currency;

@Data
@Builder
public class InvoiceTable {

    private String number;
    private String payedAt;
    private String duoDate;
    private String period;
    private String customer;
    private String document;
    private String address;
    private String total;
    private Invoice invoice;

    public static InvoiceTable of(Invoice invoice){
        return InvoiceTable.builder()
                .number(invoice.getNumber())
                .payedAt(orEmpty(invoice.getPayedAt()))
                .duoDate(date.format(invoice.getDueDate()))
                .period(PeriodUtil.formatter(invoice.period()))
                .customer(invoice.getLink().getCustomer().getName())
                .document(invoice.getLink().getCustomer().getDocument().documentNumber())
                .address(
                    invoice.getLink().getAddress().getDisplayName() +" "+
                    invoice.getLink().getLinkNumber()
                )
                .invoice(invoice)
                .total(currency.format(invoice.totalValue()))
                .build();
    }

    private static String orEmpty(LocalDateTime value ){
        return value == null ? "" : date.format(value);
    }

}


