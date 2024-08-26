package acal.application.report;

import acal.commons.LocalDateTimeUtil;
import acal.report.model.Address;
import acal.report.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static acal.commons.LocalDateTimeUtil.date;
import static acal.commons.LocalDateTimeUtil.dateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceReport {
    private String number;
    private String payedAt;
    private String dueDate;
    private String createdAt;
    private String period;
    private String partner;
    private String partnerNumber;
    private String printedAt;
    private String address;
    public static InvoiceReport adapter(Invoice invoice){
        return InvoiceReport
            .builder()
                .number(orEmpty(invoice.getNumber()))
                .payedAt(createPayedAtLabel(invoice.getPayedAt()))
                .dueDate(orEmpty(invoice.getDuoDate(), date))
                .createdAt(orEmpty(invoice.getCreatedAt()))
                .period(orEmpty(invoice.getPeriod(), LocalDateTimeUtil.period))
                .partner("Sócio: " + orEmpty(invoice.getLink().getCustomer().getName()))
                .partnerNumber(orEmpty(invoice.customer().getNumber()))
                .printedAt(orEmpty(LocalDateTime.now(), date))
                .address(createAddress(invoice.address()))
            .build();
    }

    private static String createAddress(Address address){
        return address.getType()+ " "+ address.getName();
    }

    private static String createPayedAtLabel(LocalDateTime payedAt){
        return payedAt != null ? "Pago em: " + orEmpty(payedAt) : "";
    }

    private static String orEmpty(String value){
        return value == null? "" : value;
    }
    private static String orEmpty(LocalDateTime value){
        return value == null ? "" : dateTime.format(value);
    }

    private static String orEmpty(LocalDateTime value, DateTimeFormatter formatterPeriod ){
        return value == null ? "" : formatterPeriod.format(value);
    }
}
