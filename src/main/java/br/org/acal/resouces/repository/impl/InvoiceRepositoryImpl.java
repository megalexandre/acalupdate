package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
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
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

        var pageable = invoicePaginate.pageable().orElse(PageRequest.of(0, 1000));

        List<Predicate> predicates = createPredicates(cb, invoicePaginate, invoice);
        cq.where(predicates.toArray(new Predicate[0]));

        if (pageable.getSort().isSorted()) {
            List<Order> orders = pageable.getSort().stream()
                .map(order ->
                    order.isAscending() ? cb.asc(invoice.get(order.getProperty())) :
                    cb.desc(invoice.get(order.getProperty())))
                .toList();

            cq.orderBy(orders);
        }

        TypedQuery<InvoiceModel> query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());


        List<InvoiceModel> resultList = query.getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<InvoiceModel> countRoot = countQuery.from(InvoiceModel.class);
        countQuery.select(cb.count(countRoot)).where(predicates.toArray(new Predicate[0]));
        Long totalRecords = entityManager.createQuery(countQuery).getSingleResult();

        List<Invoice> invoices = resultList.stream().map(InvoiceAdapter::map).toList();

        return new PageImpl<>(invoices, pageable, totalRecords);
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, InvoicePaginate paginate, Root<InvoiceModel> invoice) {
        List<Predicate> predicates = new ArrayList<>();
        /*
        if (invoiceFilter.getStartId() != null && invoiceFilter.getEndId() != null) {
            predicates.add(cb.between(invoice.get("number"), invoiceFilter.getStartId(), invoiceFilter.getEndId()));
        }

        if (invoiceFilter.getStatus() != null) {
            if (invoiceFilter.getStatus() == StatusPaymentInvoice.OPEN) {
                predicates.add(cb.isNull(invoice.get("payedAt")));
            } else if (invoiceFilter.getStatus() == StatusPaymentInvoice.CLOSED) {
                predicates.add(cb.isNotNull(invoice.get("payedAt")));
            }
        }

        if (invoiceFilter.getCreatedAtStart() != null && invoiceFilter.getCreatedAtEnd() != null) {
            predicates.add(cb.between(invoice.get("createdAt"), invoiceFilter.getCreatedAtStart(), invoiceFilter.getCreatedAtEnd()));
        }
        */
        return predicates;
    }
}
