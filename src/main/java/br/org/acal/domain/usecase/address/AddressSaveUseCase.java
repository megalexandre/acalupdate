package br.org.acal.domain.usecase.address;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.model.AddressFilter;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressSaveUseCase {

    private final AddressDataSource dataSource;

    public AddressSaveUseCase(AddressDataSource dataSource){
        this.dataSource = dataSource;
    }

    public Address execute(Address address) {

        val filter = AddressFilter.builder().name(address.getName()).type(address.getType()).build();
        val addresses = dataSource.find(filter);

        asser(address, addresses);

        return dataSource.save(address);
    }

    private void asser(Address address, List<Address> addresses){
        if(address.getNumber() == null){
            assertSave(addresses);
        } else {
            assertEdit(addresses, address);
        }
    }

    private void assertSave(List<Address> addresses){
        if(!addresses.isEmpty()){
            throw new RuntimeException("Valores Duplicados");
        }
    }

    private void assertEdit(List<Address> addresses, Address address){

        if(!addresses.isEmpty()){

            addresses.stream().filter(it -> address.getNumber().equals(it.getNumber())).findFirst().ifPresentOrElse(
                (it) -> {},
                () -> {
                    throw new RuntimeException("Valores Duplicados");
                }
            );

        }
    }

}
