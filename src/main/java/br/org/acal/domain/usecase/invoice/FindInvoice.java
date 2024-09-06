package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.CustomerDataSource;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindInvoice implements Usecase<Void, List<Invoice>> {

    private final InvoiceDataSource dataSource;

    public FindInvoice(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Invoice> execute(Void unused) {
        return dataSource.findAll();
    }
}
