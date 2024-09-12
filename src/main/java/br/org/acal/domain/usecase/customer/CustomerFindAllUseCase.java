package br.org.acal.domain.usecase.customer;

import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFindAllUseCase implements Usecase<Void, List<Customer>> {
    private final CustomerDataSource customerDataSource;

    public CustomerFindAllUseCase(CustomerDataSource customerDataSource){
        this.customerDataSource = customerDataSource;
    }

    @Override
    public List<Customer> execute(Void unsed) {
        return customerDataSource.findAll();
    }
}
