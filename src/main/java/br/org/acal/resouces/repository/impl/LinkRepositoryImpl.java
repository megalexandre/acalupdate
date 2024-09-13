package br.org.acal.resouces.repository.impl;

import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.model.FindLink;
import br.org.acal.domain.model.LinkFind;
import br.org.acal.resouces.adapter.CustomerAdapter;
import br.org.acal.resouces.adapter.LinkAdapter;
import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.model.LinkModel;
import br.org.acal.resouces.repository.interfaces.LinkRepositoryJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements LinkDataSource {
    private final LinkRepositoryJpa linkRepositoryJpa;
    private final EntityManager entityManager;

    public LinkRepositoryImpl(
        LinkRepositoryJpa linkRepositoryJpa,
        EntityManager entityManager
    ){
        this.linkRepositoryJpa = linkRepositoryJpa;
        this.entityManager = entityManager;
    }

    @Override
    public boolean exists(FindLink findLink) {
        return !linkRepositoryJpa.findByAddressNumber(findLink.getAddressId()).isEmpty();
    }

    @Override
    public List<Link> find(LinkFind findLink) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<LinkModel> cq = cb.createQuery(LinkModel.class);
        Root<LinkModel> root = cq.from(LinkModel.class);

        root.fetch("address", JoinType.INNER);
        Fetch<LinkModel, CustomerModel> customer = root.fetch("customer", JoinType.INNER);
        customer.fetch("partner", JoinType.INNER);

        Fetch<LinkModel, CategoryModel> category = root.fetch("category", JoinType.INNER);
        category.fetch("price", JoinType.INNER);

        cq.orderBy(
            cb.asc(root.get("address").get("type")),
            cb.asc(root.get("address").get("name")),
            cb.asc(root.get("customer").get("name"))
        );

        List<Predicate> predicates = createPredicates(cb, findLink, root);
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<LinkModel> query = entityManager.createQuery(cq);
        List<LinkModel> resultList = query.getResultList();

        return resultList.stream().map(LinkAdapter::map).toList();
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, LinkFind find, Root<LinkModel> root) {
        List<Predicate> predicates = new ArrayList<>();

        find.getAddressNumber().filter(it -> !it.isEmpty()).ifPresent(
            number -> predicates.add(
                cb.equal(root.get("address").get("number"), number)
            )
        );

        find.getACategoryNumber().filter(it -> !it.isEmpty()).ifPresent(
            number -> predicates.add(
                cb.equal(root.get("category").get("number"), number)
            )
        );

        find.getPartner().filter(it -> !it.isEmpty()).ifPresent(
            item -> predicates.add(
                cb.like(root.get("customer").get("name"), "%" + item + "%")
            )
        );

        find.getGroup().filter(it -> !it.isEmpty()).ifPresent(
            number -> predicates.add(
                cb.equal(root.get("category").get("group"), number)
            )
        );


        find.getStatus().filter(it -> !it.isEmpty()).ifPresent(
            status -> {
                switch (status) {
                    case "Ativo" -> predicates.add(cb.equal(root.get("inactive"), false));
                    case "Inativo" -> predicates.add(cb.equal(root.get("inactive"), true));
                }
            }
        );

        return predicates;
    }

    @Override
    public List<Link> findAll() {
        return linkRepositoryJpa.findAll().stream().map(LinkAdapter::map).toList();
    }
}
