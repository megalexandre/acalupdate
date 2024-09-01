package br.org.acal.resouces.repository;

import br.org.acal.domain.model.Address;
import br.org.acal.resouces.adapter.AddressAdapter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository {
    private final AddressRepositoryInterface addressRepositoryInterface;
    public AddressRepository(AddressRepositoryInterface addressRepositoryInterface){
        this.addressRepositoryInterface = addressRepositoryInterface;
    }
    public List<Address> findAll() {
        return addressRepositoryInterface.findAll().stream().map(AddressAdapter::map).toList();

        /*
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = (CriteriaBuilder) session.getCriteriaBuilder();
            CriteriaQuery<AddressModel> cq = cb.createQuery(AddressModel.class);
            Root<AddressModel> root = cq.from(AddressModel.class);
            cq.select(root);

            Order orderByType = cb.asc(root.get("type"));
            Order orderByName = cb.asc(root.get("name"));
            cq.orderBy(orderByType, orderByName);

            Query<AddressModel> query = session.createQuery(cq);
            return query.getResultList().stream();
        }
         */
    }
}
