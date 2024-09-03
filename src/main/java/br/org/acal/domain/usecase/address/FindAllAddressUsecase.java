package br.org.acal.domain.usecase.address;

import br.org.acal.domain.model.Address;
import br.org.acal.domain.repository.AddressDataSource;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllAddressUsecase implements Usecase<Void, List<Address>> {
    private final AddressDataSource addressDataSource;
    public FindAllAddressUsecase(AddressDataSource addressDataSource){
        this.addressDataSource = addressDataSource;
    }

    @Override
    public List<Address> execute(Void unused) {
        return addressDataSource.findAll();
    }
}
