package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Invoice;
import br.org.acal.resources.model.InvoiceModel;

public class InvoiceAdapter {
    public static Invoice map(InvoiceModel item){
        return Invoice
            .builder()
            .number(item.getNumber())
            .payedAt(item.getPayedAt())
            .duoDate(item.getDueDate())
            .createdAt(item.getCreatedAt())
            .period(item.getPeriod())
            .otherValues(item.getOtherValues())
            .partnerValue(item.getPartnerValue())
            .link(LinkAdapter.map(item.getLink()))
            .waterMeter(WaterMeterAdapter.map(item.getWaterMeter()))
            .build();
    }

    public static InvoiceModel map(Invoice item){
        return InvoiceModel
            .builder()
                .number(item.getNumber())
                .payedAt(item.getPayedAt())
                .dueDate(item.getDuoDate())
                .createdAt(item.getCreatedAt())
                .period(item.getPeriod())
                .link(LinkAdapter.map(item.getLink()) )
                .waterMeter(WaterMeterAdapter.map(item.getWaterMeter()))
            .build();

    }
}
