package br.org.acal.resouces.repository.impl;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.datasource.PaymentDataSource;
import br.org.acal.domain.entity.Payment;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.model.PaymentFilter;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentDataSource {

    private final InvoiceRepositoryImpl invoiceRepositoryImpl;

    public PaymentRepositoryImpl(InvoiceRepositoryImpl invoiceRepositoryImpl){
        this.invoiceRepositoryImpl = invoiceRepositoryImpl;
    }

    @Override
    public List<Payment> paginate(PaymentFilter filter) {

        val invoiceFilter = InvoiceFilter.builder().status(StatusPaymentInvoice.PAYED).build();
        filter.createdAtStart().ifPresent( invoiceFilter::setPayedAt);

        filter.createdAtStart().ifPresent( start -> {
            val end = filter.createdAtEnd().orElse(start).with(LocalTime.MAX);

            invoiceFilter.setPayedAtStart(start);
            invoiceFilter.setPayedAtEnd(end);
            }

        );

        return invoiceRepositoryImpl.find(invoiceFilter)
                .stream().map(it -> Payment.builder()
                        .customer(it.getLink().getCustomer().getName())
                        .address(it.getLink().getAddress().getDisplayName())
                        .number(it.getNumber())
                        .value(it.totalValue())
                        .createdAt(it.getPayedAt())
                        .build()).toList();
    }
}
