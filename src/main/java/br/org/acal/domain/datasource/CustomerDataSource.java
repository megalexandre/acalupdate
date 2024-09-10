package br.org.acal.domain.datasource;

import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.domain.entity.Customer;

import java.util.List;

public interface CustomerDataSource {

    List<Customer> findAll();
    List<Customer> find(FindCustomer findCustomer);

}
