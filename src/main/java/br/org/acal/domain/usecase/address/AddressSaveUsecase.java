package br.org.acal.domain.usecase.address;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

@Service
public class AddressSaveUsecase implements Usecase<Address, Address> {
    private final AddressDataSource addressDataSource;
    public AddressSaveUsecase(AddressDataSource addressDataSource){
        this.addressDataSource = addressDataSource;
    }

    @Override
    public Address execute(Address address) {
        return addressDataSource.save(address);
    }
}
