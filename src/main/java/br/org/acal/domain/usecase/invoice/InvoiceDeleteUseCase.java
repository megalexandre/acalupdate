package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import org.springframework.stereotype.Service;

import static java.util.Comparator.comparing;

@Service
public class InvoiceDeleteUseCase {

    private final InvoiceDataSource dataSource;

    public InvoiceDeleteUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void execute(String number){
        dataSource.delete(number);
    }

}
