package acal.resource.adapter;

import acal.report.model.Customer;
import acal.resource.model.CustomerModel;

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
