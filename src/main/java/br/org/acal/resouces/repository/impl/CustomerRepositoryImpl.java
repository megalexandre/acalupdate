package br.org.acal.resouces.repository.impl;

import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.resouces.adapter.CustomerAdapter;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.model.PartnerModel;
import br.org.acal.resouces.repository.interfaces.CustomerRepositoryJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerDataSource {
    private final CustomerRepositoryJpa customerRepositoryJpa;
    private final EntityManager entityManager;

    public CustomerRepositoryImpl(CustomerRepositoryJpa customerRepositoryJpa, EntityManager entityManager){
        this.customerRepositoryJpa = customerRepositoryJpa;
        this.entityManager = entityManager;
    }
    @Override
    public List<Customer> findAll() {
        return customerRepositoryJpa.findAllByOrderByNameAsc().stream().map(CustomerAdapter::map).toList();
    }

    @Override
    public List<Customer> find(FindCustomer findCustomer) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<CustomerModel> cq = cb.createQuery(CustomerModel.class);
        Root<CustomerModel> customerRoot = cq.from(CustomerModel.class);
        customerRoot.fetch("partner", JoinType.INNER);

        List<Predicate> predicates = createPredicates(cb, findCustomer, customerRoot);
        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.asc(customerRoot.get("name")));

        TypedQuery<CustomerModel> query = entityManager.createQuery(cq);
        List<CustomerModel> resultList = query.getResultList();

        return resultList.stream().map(CustomerAdapter::map).toList();
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, FindCustomer findCustomer, Root<CustomerModel> customerRoot) {
        List<Predicate> predicates = new ArrayList<>();

        if (findCustomer.getName() != null && !findCustomer.getName().isEmpty()) {

            predicates.add(cb.like(customerRoot.get("name"), "%" + findCustomer.getName().trim() + "%"));
        }
        if(findCustomer.getDocument() != null && !findCustomer.getDocument().isEmpty()){
            String cleanedDocument = findCustomer.getDocument().replaceAll("[^0-9]", "");
            Expression<String> documentWithoutPunctuation = cb.function("REPLACE", String.class, customerRoot.get("cpf"), cb.literal("."), cb.literal(""));
            documentWithoutPunctuation = cb.function("REPLACE", String.class, documentWithoutPunctuation, cb.literal("-"), cb.literal(""));
            documentWithoutPunctuation = cb.function("REPLACE", String.class, documentWithoutPunctuation, cb.literal("/"), cb.literal(""));
            documentWithoutPunctuation = cb.function("REPLACE", String.class, documentWithoutPunctuation, cb.literal(","), cb.literal(""));
            predicates.add(cb.like(documentWithoutPunctuation, "%" + cleanedDocument + "%"));
        }

        return predicates;
    }
}
