package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class InvoicePaginateUseCase implements Usecase<InvoiceFilter, Page<Invoice>> {

    private final InvoiceDataSource dataSource;

    public InvoicePaginateUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Page<Invoice> execute(InvoiceFilter filter) {
        return dataSource.paginate(filter);
    }
}
