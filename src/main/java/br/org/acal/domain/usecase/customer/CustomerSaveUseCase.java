package br.org.acal.domain.usecase.customer;

import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.domain.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaveUseCase {

    private final CustomerDataSource customerDataSource;

    public CustomerSaveUseCase(CustomerDataSource customerDataSource){
        this.customerDataSource = customerDataSource;
    }

    public Customer execute(Customer customer) {
        return customerDataSource.save(customer);
    }
}
