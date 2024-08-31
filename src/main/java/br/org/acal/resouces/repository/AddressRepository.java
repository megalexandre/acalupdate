package br.org.acal.resouces.repository;

import br.org.acal.domain.model.Address;
import br.org.acal.infra.HibernateUtil;
import br.org.acal.resouces.adapter.AddressAdapter;
import br.org.acal.resouces.model.AddressModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

public class AddressRepository {
    public List<Address> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<AddressModel> cq = cb.createQuery(AddressModel.class);
            Root<AddressModel> root = cq.from(AddressModel.class);
            cq.select(root);

            Order orderByType = cb.asc(root.get("type"));
            Order orderByName = cb.asc(root.get("name"));
            cq.orderBy(orderByType, orderByName);

            Query<AddressModel> query = session.createQuery(cq);
            return query.getResultList().stream().map(AddressAdapter::map)
                    .toList();
        }
    }
}
