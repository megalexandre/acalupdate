package br.org.acal.domain.usecase.address;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressFindAllUsecase implements Usecase<Void, List<Address>> {
    private final AddressDataSource addressDataSource;
    public AddressFindAllUsecase(AddressDataSource addressDataSource){
        this.addressDataSource = addressDataSource;
    }

    @Override
    public List<Address> execute(Void unused) {
        return addressDataSource.findAll();
    }
}
