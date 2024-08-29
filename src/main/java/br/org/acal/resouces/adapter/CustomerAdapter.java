package br.org.acal.resouces.adapter;

import br.org.acal.domain.model.Customer;
import br.org.acal.resouces.model.CustomerModel;

public class CustomerAdapter {
    public static Customer map(CustomerModel customerModel){
        return Customer
            .builder()
            .number(customerModel.getNumber())
            .name(customerModel.getName().trim() + " " + customerModel.getLastName().trim())
            .build();
    }

    public static CustomerModel map(Customer customer){
        return CustomerModel
            .builder()
                .number(customer.getNumber())
                .name(customer.getName())
            .build();
    }

}
