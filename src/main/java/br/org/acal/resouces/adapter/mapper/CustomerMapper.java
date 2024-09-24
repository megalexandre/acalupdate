package br.org.acal.resouces.adapter.mapper;

import br.org.acal.commons.util.StringUtil;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Document;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.resouces.model.CustomerModel;
import br.org.acal.resouces.model.InvoiceModel;
import lombok.val;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "document", expression = "java(getDocumentNumber(customerModel))")
    Customer map(CustomerModel customerModel);
    CustomerModel map(Customer customer);

    default Document getDocumentNumber(CustomerModel customerModel) {
        val number = getNumber(customerModel);
        val type = getType(customerModel);
        return Document.builder().number(number).type(type).build() ;
    }

    private String getType(CustomerModel customerModel){
        return customerModel.getCpf() == null ? "CNPJ" : "CPF";
    }

    private String getNumber(CustomerModel customerModel){
        return StringUtil.clean(customerModel.getCpf() == null ? customerModel.getCnpj() : customerModel.getCpf());
    }

}
