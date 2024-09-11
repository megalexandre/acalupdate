package br.org.acal.domain.usecase.address;

import br.org.acal.domain.model.FindLink;
import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.response.UsecaseResponse;
import br.org.acal.domain.usecase.Usecase;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;

import static java.util.List.of;

@Service
public class AddressDeleteUsecase implements Serializable, Usecase<String, UsecaseResponse> {
    @Serial
    private static final long serialVersionUID = 1L;
    private final AddressDataSource addressDataSource;
    private final LinkDataSource linkDataSource;

    public AddressDeleteUsecase(
            AddressDataSource addressDataSource,
            LinkDataSource linkDataSource){
        this.addressDataSource = addressDataSource;
        this.linkDataSource = linkDataSource;
    }

    @Override
    public UsecaseResponse execute(String item) {
        val find = new FindLink();
        find.setAddressId(item);

        if(!linkDataSource.exists(find)){
            addressDataSource.delete(item);
            return UsecaseResponse.builder().success(true).build();
        }

        String ERROR_MESSAGE = "Não pode ser deletado, está associado uma ligação";
        return UsecaseResponse.builder().success(false).errors(of(ERROR_MESSAGE)).build();
    }

}
