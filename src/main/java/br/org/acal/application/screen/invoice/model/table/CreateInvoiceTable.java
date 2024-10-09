package br.org.acal.application.screen.invoice.model.table;

import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.domain.entity.CreateInvoice;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Link;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateInvoiceTable {

    private Invoice invoice;
    private String address;
    private String customer;
    private String category;
    private String group;
    private String total;
    private Boolean checked;

    public static CreateInvoiceTable of(CreateInvoice it){
        return CreateInvoiceTable.builder()
                .address(it.getLink().getAddress().getDisplayName() +" "+ it.getLink().getLinkNumber())
                .invoice(it.getInvoice())
                .customer(it.getLink().getCustomer().getName())
                .group(it.getLink().getCategory().getGroup().getDescription())
                .category(it.getLink().getCategory().getName())
                .total(BigDecimalUtil.asString(it.getInvoice().totalValue()))
                .checked(false)
                .build();
    }

}
