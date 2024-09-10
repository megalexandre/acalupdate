package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindInvoiceUseCase implements Usecase<Void, List<Invoice>> {

    private final InvoiceDataSource dataSource;

    public FindInvoiceUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Invoice> execute(Void unused) {
        return dataSource.findAll();
    }
}
