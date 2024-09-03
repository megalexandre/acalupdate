package br.org.acal.domain.usecase.address;

import br.org.acal.domain.FindLink;
import br.org.acal.domain.repository.AddressDataSource;
import br.org.acal.domain.repository.LinkDataSource;
import br.org.acal.domain.response.UsecaseResponse;
import br.org.acal.domain.usecase.Usecase;
import lombok.val;
import org.springframework.stereotype.Service;

import static java.util.List.of;

@Service
public class DeleteAddressUsecase implements Usecase<String, UsecaseResponse> {
    private final AddressDataSource addressDataSource;
    private final LinkDataSource linkDataSource;
    private final String ERROR_MESSAGE = "Não pode ser deletado, está associado uma ligação";
    public DeleteAddressUsecase(
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

        return UsecaseResponse.builder().success(false).errors(of(ERROR_MESSAGE)).build();
    }

}
