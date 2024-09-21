package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceListUseCase implements Usecase<InvoiceFilter, List<Invoice>> {

    private final InvoiceDataSource dataSource;

    public InvoiceListUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public List<Invoice> execute(InvoiceFilter filter) {
        return dataSource.list(filter);
    }
}
