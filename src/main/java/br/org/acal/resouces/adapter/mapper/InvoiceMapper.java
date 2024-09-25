package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.entity.WaterMeter;
import br.org.acal.resouces.model.InvoiceModel;
import br.org.acal.resouces.model.LinkModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LinkMapper.class, WaterMeter.class})
public interface InvoiceMapper {

    @Mapping(source = "link", target = "link")
    Invoice map(InvoiceModel invoiceModel);

    InvoiceModel map(Invoice invoice);

}
