package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.resouces.repository.interfaces.CustomerRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerDataSource {
    private final CustomerRepositoryJpa customerRepositoryJpa;

    public CustomerRepositoryImpl(CustomerRepositoryJpa customerRepositoryJpa){
        this.customerRepositoryJpa = customerRepositoryJpa;
    }
    @Override
    public List<Customer> findAll() {
        return customerRepositoryJpa.findAll().stream().map(CustomerAdapter::map).toList();
    }
}
