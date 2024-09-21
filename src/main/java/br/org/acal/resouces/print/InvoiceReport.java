package br.org.acal.resouces.print;

import br.org.acal.commons.Prices;
import br.org.acal.commons.util.LocalDateTimeUtil;
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
    private List<InvoiceDetailReport> details;

    public static InvoiceReport adapter(Invoice invoice, Collection<WaterQuality> waterQuality){
        return InvoiceReport
                .builder()
                .waterQuality(waterQuality.stream().map(WaterQualityReport::adapter).toList())
                .details(InvoiceDetailReport.adapter(invoice))
                .build();
    }

}
