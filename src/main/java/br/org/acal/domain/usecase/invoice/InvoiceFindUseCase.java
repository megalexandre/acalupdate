package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.model.InvoicePaginate;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceFindUseCase implements Usecase<InvoicePaginate, List<Invoice>> {

    private final InvoiceDataSource dataSource;

    public InvoiceFindUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Invoice> execute(InvoicePaginate filter) {
        return dataSource.find(filter);
    }
}
