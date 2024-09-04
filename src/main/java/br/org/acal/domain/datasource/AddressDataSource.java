package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Address;

import java.util.List;

public interface AddressDataSource {
    List<Address> findAll();
    Address save(Address address);
    void delete(String id);

}
