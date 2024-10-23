package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.model.AddressFilter;
import br.org.acal.resouces.adapter.mapper.AddressMapper;
import br.org.acal.resouces.repository.interfaces.AddressRepositoryJpa;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressDataSource {

    private final AddressRepositoryJpa addressRepository;
    private final AddressMapper addressMapper;

    public AddressRepositoryImpl(
        AddressRepositoryJpa addressRepository,
        AddressMapper addressMapper
    ){
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<Address> findAll() {
        Sort sort = Sort.by(Sort.Order.asc("type"), Sort.Order.asc("name"));
        return addressRepository.findAll(sort).stream().map(addressMapper::map).toList();
    }

    @Override
    public List<Address> find(AddressFilter addressFilter) {
        Sort sort = Sort.by(Sort.Order.asc("type"), Sort.Order.asc("name"));
        return addressRepository.find(
                null,
                addressFilter.getName().orElse(null),
                addressFilter.getType().orElse(null),
                sort
        ).stream().map(addressMapper::map).toList();
    }

    @Override
    public Address save(Address address) {
        return addressMapper.map(addressRepository.save( addressMapper.map(address)));
    }

    @Override
    public void delete(String id) {
        addressRepository.deleteById(id);
    }
}
