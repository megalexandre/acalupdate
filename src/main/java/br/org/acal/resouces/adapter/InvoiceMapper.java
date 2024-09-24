package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Invoice;
import br.org.acal.resouces.model.InvoiceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    Invoice map(InvoiceModel invoiceModel);
    InvoiceModel map(Invoice invoice);

}
