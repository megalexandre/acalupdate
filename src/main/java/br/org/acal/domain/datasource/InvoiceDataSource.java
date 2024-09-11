package br.org.acal.domain.datasource;

import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.model.InvoicePaginate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceDataSource {
    List<Invoice> find(InvoiceFilter invoiceFilter);
    Page<Invoice> find(InvoicePaginate invoicePaginate);
    List<Invoice> findAll();

}
