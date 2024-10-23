package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.model.AddressFilter;

import java.util.List;

public interface AddressDataSource extends DefaultDataSource<Address> {

    List<Address> findAll();
    List<Address> find(AddressFilter addressFilter);

    Address save(Address address);
    void delete(String id);

}
