package br.org.acal.domain.repository;

import br.org.acal.domain.model.Address;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AddressDataSource {
    List<Address> findAll();
    Address save(Address address);

}
