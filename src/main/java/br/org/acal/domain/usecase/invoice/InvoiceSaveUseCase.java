package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceSaveUseCase implements Usecase<Invoice, Invoice> {

    private final InvoiceDataSource dataSource;

    public InvoiceSaveUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Invoice execute(Invoice invoice) {
        return dataSource.save(invoice);
    }
}
