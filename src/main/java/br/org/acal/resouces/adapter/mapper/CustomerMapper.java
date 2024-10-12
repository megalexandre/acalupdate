package br.org.acal.resouces.adapter.mapper;

import br.org.acal.commons.util.StringUtil;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Document;
import br.org.acal.resouces.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "customerModel", target = "document", qualifiedByName = "mapDocument")
    Customer map(CustomerModel customerModel);

    @Mapping(source = "customer", target = "cpf", qualifiedByName = "documentToCpf")
    CustomerModel map(Customer customer);

    @Named("mapDocument")
    default Document mapDocument(CustomerModel customerModel) {
        return Document.builder()
                .type(customerModel.getCpf() == null ? "CNPJ" : "CPF")
                .number(StringUtil.clean(customerModel.getCpf() == null ? customerModel.getCnpj() : customerModel.getCpf()))
                .build();
    }

    @Named("documentToCpf")
    default String documentToCpf(Customer customer) {
        return customer.getDocument().getNumber();
    }

}