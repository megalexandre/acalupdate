package br.org.acal.resouces.adapter.mapper;

import br.org.acal.resouces.model.CustomerModel;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CustomerMapper.class})
class CustomerMapperTest {
    @Test
    void test(){
        CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

        val customerModel = CustomerModel.builder()
                .number("1")
                .name("Alexandre")
                .cpf("03396885562")
                .phoneNumber("71988872749")
            .build();
        val customer = mapper.map(customerModel);


        assertEquals(customerModel.getNumber(), customer.getNumber());
        assertEquals(customerModel.getName(), customer.getName());
        assertEquals(customerModel.getPhoneNumber(), customer.getPhoneNumber());

        assertEquals(customerModel.getCpf(), customer.getDocument().getNumber());
        assertEquals("CPF", customer.getDocument().getType());
    }
}
