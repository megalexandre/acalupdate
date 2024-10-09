package br.org.acal.resouces.repository.impl;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.resouces.adapter.mapper.InvoiceMapper;
import br.org.acal.resouces.model.InvoiceModel;
import br.org.acal.resouces.repository.interfaces.InvoiceRepositoryJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class InvoiceRepositoryImpl implements InvoiceDataSource {

    private final InvoiceRepositoryJpa repositoryJpa;
    private final InvoiceMapper invoiceMapper;

    public InvoiceRepositoryImpl(
            InvoiceRepositoryJpa repositoryJpa,
            InvoiceMapper invoiceMapper
    ){
        this.repositoryJpa = repositoryJpa;
        this.invoiceMapper = invoiceMapper ;
    }

    @Override
    public List<Invoice> findAll() {
        return repositoryJpa.findByPayedAtIsNull().stream().map(invoiceMapper::map).toList();
    }

    @Override
    public Invoice save(Invoice invoice) {
        invoice.setWaterMeter(null);
        return invoiceMapper.map(repositoryJpa.save(invoiceMapper.map(invoice)));
    }

    @Override
    public List<Invoice> save(List<Invoice> invoices) {
        List<InvoiceModel> items = invoices.stream().map(invoiceMapper::map).toList();
        List<InvoiceModel> savedItems = repositoryJpa.saveAll(items);
        return savedItems.stream().map(invoiceMapper::map).toList();
    }

    @Override
    public List<Invoice> find(InvoiceFilter invoiceFilter) {
        return baseQuery(invoiceFilter);
    }

    @Override
    public Page<Invoice> paginate(InvoiceFilter invoiceFilter) {
        return baseQuery(invoiceFilter, invoiceFilter.pageable().orElse(createPageable()));
    }

    @Override
    public List<Invoice> list(InvoiceFilter invoiceFilter) {
        return baseQuery(invoiceFilter);
    }

    private List<Invoice> baseQuery(InvoiceFilter invoiceFilter) {
        Boolean statusOpen = createStatus(invoiceFilter,StatusPaymentInvoice.OPEN);
        Boolean statusPayed = createStatus(invoiceFilter,StatusPaymentInvoice.PAYED);
        Boolean statusOverdue = createStatus(invoiceFilter,StatusPaymentInvoice.OVERDUE);

        return repositoryJpa.findInvoices(
            invoiceFilter.selectedNumber().orElse(null),
            invoiceFilter.selectedCustomer().orElse(null),
            invoiceFilter.selectedCategory().orElse(null),
            invoiceFilter.selectedAddress().orElse(null),
            invoiceFilter.period().map(Period::startMonth).orElse(null),
            invoiceFilter.period().map(Period::endMonth).orElse(null),
            statusOpen,
            statusPayed,
            statusOverdue,
            LocalDateTime.now()
        ).stream().map(invoiceMapper::map).toList();
    }
    private Page<Invoice> baseQuery(InvoiceFilter invoiceFilter, Pageable pageable) {
        Boolean statusOpen = createStatus(invoiceFilter,StatusPaymentInvoice.OPEN);
        Boolean statusPayed = createStatus(invoiceFilter,StatusPaymentInvoice.PAYED);
        Boolean statusOverdue = createStatus(invoiceFilter,StatusPaymentInvoice.OVERDUE);

        var page = repositoryJpa.paginateInvoices(
                invoiceFilter.selectedNumber().orElse(null),
                invoiceFilter.selectedCustomer().orElse(null),
                invoiceFilter.selectedCategory().orElse(null),
                invoiceFilter.selectedAddress().orElse(null),
                invoiceFilter.period().map(Period::startMonth).orElse(null),
                invoiceFilter.period().map(Period::endMonth).orElse(null),
                statusOpen,
                statusPayed,
                statusOverdue,
                LocalDateTime.now(),
                pageable
        );

        var data = page.stream().map(invoiceMapper::map).toList();

        return new PageImpl<>(data, pageable, page.getTotalElements());
    }

    private Boolean createStatus(InvoiceFilter invoiceFilter, StatusPaymentInvoice status ){
        return invoiceFilter.status()
            .filter(item  -> item.equals(status))
            .map(unused -> true)
            .orElse(null);
    }

    private Pageable createPageable(){

        var sort = Sort.by(
            Sort.Order.desc("period"),
            Sort.Order.desc("link.address.name"),
            Sort.Order.desc("link.linkNumber"),
            Sort.Order.asc("link.customer.name")
        );

        return PageRequest.of(0, 100, sort);
    }
}
