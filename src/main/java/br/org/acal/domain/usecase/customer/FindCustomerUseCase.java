package br.org.acal.domain.usecase.customer;

import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCustomerUseCase implements Usecase<FindCustomer, List<Customer>> {
    private final CustomerDataSource customerDataSource;

    public FindCustomerUseCase(CustomerDataSource customerDataSource){
        this.customerDataSource = customerDataSource;
    }

    @Override
    public List<Customer> execute(FindCustomer find) {
        return customerDataSource.find(find);
    }
}
