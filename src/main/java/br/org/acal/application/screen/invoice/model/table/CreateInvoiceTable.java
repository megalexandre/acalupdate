package br.org.acal.application.screen.invoice.model.table;

import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.domain.entity.CreateInvoice;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Link;
import lombok.Builder;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;

@Data
@Builder
public class CreateInvoiceTable {

    private Invoice invoice;
    private String linkNumber;
    private String address;
    private String customer;
    private String category;
    private String group;
    private String water;
    private String total;
    private Boolean checked;

    public static CreateInvoiceTable of(CreateInvoice it){
        return CreateInvoiceTable.builder()
                .linkNumber(it.getLink().getLinkNumber())
                .address(it.getLink().getAddress().getDisplayName())
                .invoice(it.getInvoice())
                .customer(it.getLink().getCustomer().getName())
                .group(it.getLink().getCategory().getGroup().getDescription())
                .category(it.getLink().getCategory().getName())
                .water(formatAsNumber(it.getInvoice().useFullConsumption()))
                .total(BigDecimalUtil.asString(it.getInvoice().totalValue()))
                .checked(false)
                .build();
    }

    private static String formatAsNumber(Double value) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(0);
        return numberFormat.format(value);
    }

}
