package br.org.acal.resouces.repository.impl;

import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.resouces.adapter.mapper.CustomerMapper;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.repository.interfaces.CustomerRepositoryJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerDataSource {
    private final CustomerRepositoryJpa customerRepositoryJpa;
    private final EntityManager entityManager;
    private final CustomerMapper customerMapper;

    public CustomerRepositoryImpl(
            CustomerRepositoryJpa customerRepositoryJpa,
            EntityManager entityManager,
            CustomerMapper customerMapper
    ){
        this.customerRepositoryJpa = customerRepositoryJpa;
        this.entityManager = entityManager;
        this.customerMapper = customerMapper;
    }
    @Override
    public List<Customer> findAll() {
        return customerRepositoryJpa.findAllByOrderByNameAsc().stream().map(customerMapper::map).toList();
    }

    @Override
    public List<Customer> find(FindCustomer findCustomer) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<CustomerModel> cq = cb.createQuery(CustomerModel.class);
        Root<CustomerModel> customerRoot = cq.from(CustomerModel.class);
        customerRoot.fetch("partner", JoinType.LEFT);

        List<Predicate> predicates = createPredicates(cb, findCustomer, customerRoot);
        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.asc(customerRoot.get("name")));

        TypedQuery<CustomerModel> query = entityManager.createQuery(cq);
        List<CustomerModel> resultList = query.getResultList();

        return resultList.stream().map(customerMapper::map).toList();
    }

    @Override
    public Customer save(Customer customer) {
        return customerMapper.map(customerRepositoryJpa.save(customerMapper.map(customer)));
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, FindCustomer findCustomer, Root<CustomerModel> customerRoot) {
        List<Predicate> predicates = new ArrayList<>();

        findCustomer.getName()
            .filter(this::isValid)
            .ifPresent(name -> predicates.add(
                cb.like(cb.lower(customerRoot.get("name")), "%" + name.trim().toLowerCase() + "%")
            ));

        findCustomer.getDocument()
            .filter(this::isValid)
            .map(this::cleanDocument)
            .ifPresent(cleanedDocument -> {
                Expression<String> documentWithoutPunctuation = removePunctuation(cb, customerRoot.get("cpf"));
                predicates.add(cb.like(documentWithoutPunctuation, "%" + cleanedDocument + "%"));
            });

        findCustomer.getId()
            .ifPresent(id ->
                predicates.add(cb.equal(customerRoot.get("id"), id))
            );

        findCustomer.getActive()
            .ifPresent( active ->
                predicates.add(cb.equal(customerRoot.get("active"), active))
            );

        return predicates;
    }

    private String cleanDocument(String document) {
        return document.replaceAll("[^0-9]", "");
    }

    private Expression<String> removePunctuation(CriteriaBuilder cb, Path<String> documentPath) {
        String replace = "replace";
        Expression<String> documentWithoutPunctuation = cb.function(replace, String.class, documentPath, cb.literal("."), cb.literal(""));
        documentWithoutPunctuation = cb.function(replace, String.class, documentWithoutPunctuation, cb.literal("-"), cb.literal(""));
        documentWithoutPunctuation = cb.function(replace, String.class, documentWithoutPunctuation, cb.literal("/"), cb.literal(""));
        return cb.function(replace, String.class, documentWithoutPunctuation, cb.literal(","), cb.literal(""));
    }

    private boolean isValid(String value){
        return !value.trim().isEmpty();
    }
}
