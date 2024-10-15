package br.org.acal.domain.usecase.address;

import br.org.acal.domain.datasource.AddressDataSource;
import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.model.LinkFilter;
import br.org.acal.domain.model.UseCaseResponse;
import br.org.acal.domain.usecase.Usecase;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;

import static java.util.List.of;

@Service
public class AddressDeleteUsecase implements Serializable, Usecase<String, UseCaseResponse> {
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
    public UseCaseResponse execute(String item) {
        val find = LinkFilter.builder().addressNumber(item).build() ;

        if(!linkDataSource.exists(find)){
            addressDataSource.delete(item);
            return UseCaseResponse.builder().success(true).build();
        }

        String ERROR_MESSAGE = "Não pode ser deletado, está associado uma ligação";
        return UseCaseResponse.builder().success(false).errors(of(ERROR_MESSAGE)).build();
    }

}
