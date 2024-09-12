package br.org.acal.resouces.repository.impl;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.model.InvoicePaginate;
import br.org.acal.resouces.adapter.InvoiceAdapter;
import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.model.InvoiceModel;
import br.org.acal.resouces.model.LinkModel;
import br.org.acal.resouces.repository.interfaces.InvoiceRepositoryJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    public List<Invoice> find(InvoiceFilter invoiceFilter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InvoiceModel> cq = cb.createQuery(InvoiceModel.class);
        Root<InvoiceModel> invoice = cq.from(InvoiceModel.class);
        invoice.fetch("waterMeter", JoinType.LEFT);
        Fetch<InvoiceModel, LinkModel> link = invoice.fetch("link", JoinType.INNER);
        Fetch<CustomerModel, LinkModel> customer = link.fetch("customer", JoinType.INNER);
        customer.fetch("partner", JoinType.INNER);
        link.fetch("address", JoinType.INNER);
        Fetch<CategoryModel, LinkModel> category = link.fetch("category", JoinType.INNER);
        category.fetch("price", JoinType.INNER);
        //List<Predicate> predicates = createPredicates(cb, invoiceFilter, invoice);
        //cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<InvoiceModel> query = entityManager.createQuery(cq);
        List<InvoiceModel> resultList = query.getResultList();
        return resultList.stream().map(InvoiceAdapter::map).toList();
    }
    @Override
    public Page<Invoice> find(InvoicePaginate invoicePaginate) {

        var sort = Sort.by(
                Sort.Order.desc("period"),
                Sort.Order.desc("link.address.name"),
                Sort.Order.asc("link.customer.name")
        );

        var pageable = invoicePaginate.pageable().orElse(PageRequest.of(0, 100, sort));


        Boolean statusOpen = invoicePaginate.status()
            .filter(status -> status.equals(StatusPaymentInvoice.OPEN))
            .map(_ -> true)
            .orElse(null);

        Boolean statusPayed = invoicePaginate.status()
            .filter(status -> status.equals(StatusPaymentInvoice.PAYED))
            .map(_ -> true)
            .orElse(null);

        Boolean statusOverdue = invoicePaginate.status()
            .filter(status -> status.equals(StatusPaymentInvoice.OVERDUE))
            .map(_ -> true)
            .orElse(null);

        var data = repositoryJpa.findInvoices(
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

        List<Invoice> invoices = data.getContent().stream()
            .map(InvoiceAdapter::map)
            .toList();

        return new PageImpl<>(invoices, pageable, data.getTotalElements());
    }

}
