package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.model.FindInvoice;
import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
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
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
    public List<Invoice> find(FindInvoice findInvoice) {
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
        List<Predicate> predicates = createPredicates(cb, findInvoice, invoice);
        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<InvoiceModel> query = entityManager.createQuery(cq);
        List<InvoiceModel> resultList = query.getResultList();
        return resultList.stream().map(InvoiceAdapter::map).toList();
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, FindInvoice findInvoice, Root<InvoiceModel> invoice) {
        List<Predicate> predicates = new ArrayList<>();

        if (findInvoice.getCustomerId() != null) {
            predicates.add(cb.equal(invoice.get("link").get("customer").get("number"), findInvoice.getCustomerId()));
        }

        if (findInvoice.getStartId() != null && findInvoice.getEndId() != null) {
            predicates.add(cb.between(invoice.get("number"), findInvoice.getStartId(), findInvoice.getEndId()));
        }

        if (findInvoice.getStatus() != null) {
            if (findInvoice.getStatus() == StatusPaymentInvoice.OPEN) {
                predicates.add(cb.isNull(invoice.get("payedAt")));
            } else if (findInvoice.getStatus() == StatusPaymentInvoice.CLOSED) {
                predicates.add(cb.isNotNull(invoice.get("payedAt")));
            }
        }

        if (findInvoice.getCreatedAtStart() != null && findInvoice.getCreatedAtEnd() != null) {
            predicates.add(cb.between(invoice.get("createdAt"), findInvoice.getCreatedAtStart(), findInvoice.getCreatedAtEnd()));
        }

        return predicates;
    }
}
