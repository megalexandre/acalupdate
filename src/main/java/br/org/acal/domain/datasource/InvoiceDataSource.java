package br.org.acal.domain.datasource;

import br.org.acal.domain.FindInvoice;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceDataSource {
    List<Invoice> find(FindInvoice findInvoice);
    List<Invoice> findAll();

}
