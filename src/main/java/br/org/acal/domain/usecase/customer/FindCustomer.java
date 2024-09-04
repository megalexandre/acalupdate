package br.org.acal.domain.usecase.customer;

import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCustomer implements Usecase<Void, List<Customer>> {
    private final CustomerDataSource customerDataSource;

    public FindCustomer(CustomerDataSource customerDataSource){
        this.customerDataSource = customerDataSource;
    }

    @Override
    public List<Customer> execute(Void unused) {
        return customerDataSource.findAll();
    }
}
