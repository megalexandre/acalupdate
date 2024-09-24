package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.model.InvoiceFilter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceDataSource {
    List<Invoice> find(InvoiceFilter invoiceFilter);
    Page<Invoice> paginate(InvoiceFilter invoiceFilter);
    List<Invoice> list(InvoiceFilter invoiceFilter);
    List<Invoice> findAll();
    Invoice save(Invoice invoice);

}
