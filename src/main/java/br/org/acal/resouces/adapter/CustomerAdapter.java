package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Document;
import br.org.acal.resouces.model.CustomerModel;
import lombok.val;

import javax.xml.parsers.DocumentBuilder;

public class CustomerAdapter {
    public static Customer map(CustomerModel customerModel){

        val document = Document.builder()
                .type(customerModel.getCpf() == null ? "CNPJ" : "CPF" )
                .number(customerModel.getCpf() == null ? customerModel.getCnpj() : customerModel.getCpf())
            .build();

        return Customer
            .builder()
            .number(customerModel.getNumber())
            .name(customerModel.getName().trim() + " " + customerModel.getLastName().trim())
            .document( document)
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
