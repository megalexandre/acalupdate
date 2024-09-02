package br.org.acal.domain.repository;

import br.org.acal.domain.FindInvoice;
import br.org.acal.domain.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceDataSource {
    List<Invoice> find(FindInvoice findInvoice);
}
