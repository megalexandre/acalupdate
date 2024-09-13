package br.org.acal.resouces.repository.impl;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.model.InvoicePaginate;
import br.org.acal.resouces.adapter.InvoiceAdapter;
import br.org.acal.resouces.repository.interfaces.InvoiceRepositoryJpa;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InvoiceRepositoryImpl implements InvoiceDataSource {
    private final InvoiceRepositoryJpa repositoryJpa;
    private final EntityManager entityManager;
    public InvoiceRepositoryImpl(InvoiceRepositoryJpa repositoryJpa, EntityManager entityManager){
        this.entityManager = entityManager;
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public List<Invoice> findAll() {
        return repositoryJpa.findByPayedAtIsNull().stream().map(InvoiceAdapter::map).toList();
    }
    @Override
    public List<Invoice> find(InvoicePaginate invoicePaginate) {
        return baseQuery(invoicePaginate);
    }

    @Override
    public Page<Invoice> paginate(InvoicePaginate invoicePaginate) {
        return baseQuery(invoicePaginate, invoicePaginate.pageable().orElse(createPageable()));
    }

    private List<Invoice> baseQuery(InvoicePaginate invoicePaginate) {
        Boolean statusOpen = createStatus(invoicePaginate,StatusPaymentInvoice.OPEN);
        Boolean statusPayed = createStatus(invoicePaginate,StatusPaymentInvoice.PAYED);
        Boolean statusOverdue = createStatus(invoicePaginate,StatusPaymentInvoice.OVERDUE);

        return repositoryJpa.findInvoices(
            invoicePaginate.selectedNumber().orElse(null),
            invoicePaginate.selectedCustomer().orElse(null),
            invoicePaginate.selectedCategory().orElse(null),
            invoicePaginate.selectedAddress().orElse(null),
            invoicePaginate.period().map(Period::startMonth).orElse(null),
            invoicePaginate.period().map(Period::endMonth).orElse(null),
            statusOpen,
            statusPayed,
            statusOverdue,
            LocalDateTime.now()
        ).stream().map(InvoiceAdapter::map).toList();
    }
    private Page<Invoice> baseQuery(InvoicePaginate invoicePaginate, Pageable pageable) {
        Boolean statusOpen = createStatus(invoicePaginate,StatusPaymentInvoice.OPEN);
        Boolean statusPayed = createStatus(invoicePaginate,StatusPaymentInvoice.PAYED);
        Boolean statusOverdue = createStatus(invoicePaginate,StatusPaymentInvoice.OVERDUE);

        var page = repositoryJpa.paginateInvoices(
                invoicePaginate.selectedNumber().orElse(null),
                invoicePaginate.selectedCustomer().orElse(null),
                invoicePaginate.selectedCategory().orElse(null),
                invoicePaginate.selectedAddress().orElse(null),
                invoicePaginate.period().map(Period::startMonth).orElse(null),
                invoicePaginate.period().map(Period::endMonth).orElse(null),
                statusOpen,
                statusPayed,
                statusOverdue,
                LocalDateTime.now(),
                pageable
        );

        var data = page.stream().map(InvoiceAdapter::map).toList();

        return new PageImpl<>(data, pageable, page.getTotalElements());
    }

    private Boolean createStatus(InvoicePaginate invoicePaginate, StatusPaymentInvoice status ){
        return invoicePaginate.status()
            .filter(item  -> item.equals(status))
            .map(unused -> true)
            .orElse(null);
    }

    private Pageable createPageable(){

        var sort = Sort.by(
            Sort.Order.desc("period"),
            Sort.Order.desc("link.address.name"),
            Sort.Order.asc("link.customer.name")
        );

        return PageRequest.of(0, 100, sort);
    }
}
