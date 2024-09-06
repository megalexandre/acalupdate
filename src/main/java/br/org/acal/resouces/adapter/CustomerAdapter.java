package br.org.acal.resouces.adapter;

import br.org.acal.commons.StringUtil;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Document;
import br.org.acal.resouces.model.CustomerModel;
import lombok.val;

public class CustomerAdapter {
    public static Customer map(CustomerModel customerModel){
        return Customer
            .builder()
            .number(customerModel.getNumber())
            .name(customerModel.getName().trim())
            .document(Document.builder()
                .type(getDocumentType(customerModel))
                .number(getCleanDocumentNumber(customerModel))
                .build())
            .build();
    }

    private static String getCleanDocumentNumber(CustomerModel customerModel){
        return StringUtil.clean(customerModel.getCpf() == null ? customerModel.getCnpj() : customerModel.getCpf());
    }

    private static String getDocumentType(CustomerModel customerModel){
        return customerModel.getCpf() == null ? "CNPJ" : "CPF";
    }

    public static CustomerModel map(Customer customer){
        return CustomerModel
            .builder()
                .number(customer.getNumber())
                .name(customer.getName())
            .build();
    }

}
