package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.model.Address;
import br.org.acal.domain.repository.AddressDataSource;
import br.org.acal.resouces.adapter.AddressAdapter;
import br.org.acal.resouces.repository.interfaces.AddressRepositoryB;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressDataSource {
    private final AddressRepositoryB addressRepository;
    public AddressRepositoryImpl(AddressRepositoryB addressRepository){
        this.addressRepository = addressRepository;
    }
    public List<Address> findAll() {
        Sort sort = Sort.by(Sort.Order.asc("type"), Sort.Order.asc("name"));
        return addressRepository.findAll(sort).stream().map(AddressAdapter::map).toList();
    }

    @Override
    public Address save(Address address) {
        return AddressAdapter.map(addressRepository.save( AddressAdapter.map(address)));
    }
}
