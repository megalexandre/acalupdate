package br.org.acal.application.report;

import br.org.acal.commons.util.LocalDateTimeUtil;
import br.org.acal.commons.Prices;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.WaterQuality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceReport {

    private List<WaterQualityReport> waterQuality;

    private String number;
    private String payedAt;
    private String dueDate;
    private String createdAt;
    private String period;
    private String partner;
    private String partnerNumber;
    private String printedAt;
    private String address;
    private String partnerValue;
    private String otherValues;
    private String totalValue;
    private String category;
    private String actualMeter;
    private String previousMeter;

    private String overLimit;
    private String consumptionStart;
    private String consumptionEnd;
    private String consumption;
    private String usefulConsumption;
    private String waterValue;
    private String freeTier;


    public static InvoiceReport adapter(Invoice invoice, Collection<WaterQuality> waterQuality){
        return InvoiceReport
            .builder()
                .number(getNumber(invoice))
                .payedAt(createPayedAt(invoice))
                .dueDate(createDuoDate(invoice))
                .createdAt(createCreatedAt(invoice))
                .period(createPeriod(invoice))
                .partner(createPartner(invoice))
                .partnerNumber(createNumber(invoice))
                .printedAt(createPrintedAt())
                .address(createAddress(invoice))

                .partnerValue(orEmpty(invoice.getPartnerValue()))
                .otherValues(orEmpty(invoice.getOtherValues()))
                .totalValue(orEmpty(invoice.totalValue()))
                .overLimit(orEmpty(invoice.useFullConsumption()))

                .category("Categoria: " + orEmpty(invoice.category().getName()))
                .consumptionStart(createConsuptionLabel(invoice))
                .consumptionEnd("")
                .consumption("Consumo Total: " + orEmpty(invoice.consumptionTotal()))
                .usefulConsumption("Consumo considerado: " + orEmpty((invoice.useFullConsumption())))
                .waterValue(createWaterValue(invoice))
                .freeTier(createFreeTier())
                .waterQuality(waterQuality.stream().map(WaterQualityReport::adapter).toList())
            .build();
    }

    private static String createConsuptionLabel(Invoice invoice){
        return  """ 
           <html>Anterior: %s<br/> Atual: %s<br/> </html>
           """.formatted(orEmpty(invoice.consumptionStart()), orEmpty(invoice.consumptionEnd()));
    }
    private static String createFreeTier(){
        return "Gratuidade: " + orEmpty(Prices.freeTierWater);
    }

    private static String createWaterValue(Invoice invoice){
        return orEmpty(invoice.waterValue());
    }
    private static String getNumber(Invoice invoice){
        return orEmpty(invoice.getNumber());
    }

    private static String createPayedAt(Invoice invoice){
        return createPayedAtLabel(invoice.getPayedAt());
    }

    private static String createDuoDate(Invoice invoice){
        return orEmpty(invoice.getDuoDate(), LocalDateTimeUtil.date);
    }

    private static String createCreatedAt(Invoice invoice){
        return orEmpty(invoice.getCreatedAt());
    }

    private static String createPartner(Invoice invoice){
        return "Sócio: " + orEmpty(invoice.getLink().getCustomer().getName());
    }

    private static String createNumber(Invoice invoice){
        return orEmpty(invoice.customer().getNumber());
    }

    private static String createPrintedAt(){
        return orEmpty(LocalDateTime.now(), LocalDateTimeUtil.date);
    }

    private static String createAddress(Invoice invoice){
        return createAddress(invoice.address());
    }

    private static String orEmpty(Double value){
        return value == null ? "": new DecimalFormat("#,###.##").format(value);
    }

    private static String createPeriod(Invoice invoice){
        return orEmpty(invoice.getPeriod(), LocalDateTimeUtil.period);
    }

    private static String createAddress(Address address){
        return "Endereço: " + address.getType()+ " "+ address.getName();
    }

    private static String createPayedAtLabel(LocalDateTime payedAt){
        return payedAt != null ? "Pago em: " + orEmpty(payedAt, LocalDateTimeUtil.date) : "";
    }

    private static String orEmpty(BigDecimal value){
        return (value == null ? "R$ 0,00" : getCurrencyInstance(Locale.of("pt", "BR")).format(value));
    }
    private static String orEmpty(String value){
        return value == null? "" : value;
    }
    private static String orEmpty(LocalDateTime value){
        return value == null ? "" : LocalDateTimeUtil.dateTime.format(value);
    }
    private static String orEmpty(LocalDateTime value, DateTimeFormatter formatterPeriod ){
        return value == null ? "" : formatterPeriod.format(value);
    }
}
