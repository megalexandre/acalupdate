package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.model.LinkFilter;
import br.org.acal.resouces.adapter.mapper.LinkMapper;
import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.model.LinkModel;
import br.org.acal.resouces.repository.interfaces.LinkRepositoryJpa;
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
public class LinkRepositoryImpl implements LinkDataSource {

    private final LinkRepositoryJpa linkRepositoryJpa;
    private final EntityManager entityManager;
    private final LinkMapper linkMapper;

    public LinkRepositoryImpl(
        LinkRepositoryJpa linkRepositoryJpa,
        EntityManager entityManager,
        LinkMapper linkMapper
    ){
        this.linkRepositoryJpa = linkRepositoryJpa;
        this.entityManager = entityManager;
        this.linkMapper = linkMapper;
    }

    @Override
    public boolean exists(LinkFilter findLink) {
        return findLink.getAddressNumber().map(item ->
                !linkRepositoryJpa.findByAddressNumber(item).isEmpty()
        ).orElseThrow(() -> new RuntimeException("Address number is not present"));
    }

    @Override
    public List<Link> find(LinkFilter findLink) {
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

        return resultList.stream().map(linkMapper::map).toList();
    }

    @Override
    public void active(Link link) {
        linkRepositoryJpa.active(link.getNumber());
    }

    @Override
    public void inactive(Link link) {
        linkRepositoryJpa.inactive(link.getNumber());
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, LinkFilter find, Root<LinkModel> root) {
        List<Predicate> predicates = new ArrayList<>();

        find.getAddressNumber().filter(it -> !it.isEmpty()).ifPresent(
            number -> predicates.add(
                cb.equal(root.get("address").get("number"), number)
            )
        );

        find.getLinkNumber().ifPresent(linkNumber -> {
            predicates.add(
                cb.equal(root.get("linkNumber"), linkNumber)
            );
        });

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
        return linkRepositoryJpa.findAll().stream().map(linkMapper::map).toList();
    }

    @Override
    public Link save(Link link) {
        return linkMapper.map(linkRepositoryJpa.save(linkMapper.map(link)));
    }

    @Override
    public List<Link> findAllWithoutInvoiceForDate(Period period){
        return linkRepositoryJpa.findAllWithoutInvoiceForDate(period.startMonth()).stream().map(linkMapper::map).toList();
    }

}
