package br.org.acal.domain.usecase.address;

import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.model.AddressFilter;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressFindUsecase implements Usecase<AddressFilter, List<Address>> {

    private final AddressDataSource addressDataSource;

    public AddressFindUsecase(AddressDataSource addressDataSource){
        this.addressDataSource = addressDataSource;
    }

    @Override
    public List<Address> execute(AddressFilter addressFilter) {
        return addressDataSource.find(addressFilter);
    }
}