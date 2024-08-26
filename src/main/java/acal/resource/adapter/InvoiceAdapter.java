package acal.resource.adapter;

import acal.report.model.Invoice;
import acal.resource.model.InvoiceModel;

public class InvoiceAdapter {
    public static Invoice map(InvoiceModel item){
        return Invoice
            .builder()
            .number(item.getNumber())
            .payedAt(item.getPayedAt())
            .duoDate(item.getDueDate())
            .createdAt(item.getCreatedAt())
            .period(item.getPeriod())
            .link(LinkAdapter.map(item.getLink()) )
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
            .build();

    }
}
