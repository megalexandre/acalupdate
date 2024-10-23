package br.org.acal.domain.usecase.address;

import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.model.AddressFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressFindUseCase {

    private final AddressDataSource addressDataSource;

    public AddressFindUseCase(AddressDataSource addressDataSource){
        this.addressDataSource = addressDataSource;
    }

    public List<Address> execute(AddressFilter addressFilter) {

        if(addressFilter == null){
            addressFilter = AddressFilter.builder().build();
        }

        return addressDataSource.find(addressFilter);
    }
}