package br.org.acal.resouces.repository;

import br.org.acal.domain.FindInvoice;
import br.org.acal.domain.StatusPaymentInvoice;
import br.org.acal.infra.HibernateUtil;
import br.org.acal.domain.model.Invoice;
import br.org.acal.resouces.adapter.InvoiceAdapter;
import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.model.InvoiceModel;
import br.org.acal.resouces.model.LinkModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class InvoiceRepository {
    public List<Invoice> find(FindInvoice findInvoice) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<InvoiceModel> cq = cb.createQuery(InvoiceModel.class);
            Root<InvoiceModel> invoice = cq.from(InvoiceModel.class);

            invoice.fetch("waterMeter", JoinType.LEFT);
            Fetch<InvoiceModel, LinkModel> link = invoice.fetch("link", JoinType.INNER);
            Fetch<CustomerModel, LinkModel> customer = link.fetch("customer", JoinType.INNER);
                customer.fetch("partner", JoinType.INNER);

            link.fetch("address", JoinType.INNER);

            Fetch<CategoryModel, LinkModel> category = link.fetch("category", JoinType.INNER);
            category.fetch("price", JoinType.INNER);

            cq.where(createPredicates(cb, findInvoice, invoice).toArray(new Predicate[0]));
            Query<InvoiceModel> query = session.createQuery(cq);

            return query.getResultList().stream().map(InvoiceAdapter::map).toList();
        }
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, FindInvoice findInvoice, Root<InvoiceModel> invoice ){
        List<Predicate> predicates = new ArrayList<>();


        if(findInvoice.getCustomerId() != null){
            predicates.add(cb.equal(invoice.get("link").get("customer").get("number"),findInvoice.getCustomerId()));
        }

        if (findInvoice.getStartId()!= null && findInvoice.getEndId() != null) {
            predicates.add(cb.between(invoice.get("number"), findInvoice.getStartId(), findInvoice.getEndId()));
        }

        if(findInvoice.getStatus() != null){

            if(findInvoice.getStatus() == StatusPaymentInvoice.OPEN){
                predicates.add(cb.isNull(invoice.get("payedAt")));
            }

            if(findInvoice.getStatus() == StatusPaymentInvoice.CLOSED){
                predicates.add(cb.isNotNull(invoice.get("payedAt")));
            }
        }

        if(findInvoice.getCreatedAtStart() != null && findInvoice.getCreatedAtEnd()!= null){
            predicates.add(cb.between(invoice.get("createdAt"), findInvoice.getCreatedAtStart(), findInvoice.getCreatedAtEnd()));
        }

        return predicates;
    }
}
