package br.org.acal.domain.usecase.customer;

import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.domain.entity.Customer;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaveUseCase {

    private final CustomerDataSource dataSource;

    public CustomerSaveUseCase(CustomerDataSource dataSource){
        this.dataSource = dataSource;
    }

    public Customer execute(Customer customer) {
        assertExecute(customer);
        return dataSource.save(customer);
    }

    private void assertExecute(Customer customer){
        if(customer.getNumber() == null){
            assertSave(customer);
        } else{
            assertUpdate(customer);
        }
    }

    private void assertSave(Customer customer){

        val customerPartnerNumber = dataSource.find(FindCustomer.builder().partnerNumber(customer.getPartnerNumber()).build());
        if(!customerPartnerNumber.isEmpty()){
            throw new RuntimeException("O número de sócio deve ser unico");
        }


    }

    private void assertUpdate(Customer customer){

    }

}
