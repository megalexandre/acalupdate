package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.CreateInvoice;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.entity.Period;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceSaveAllUseCase {

    private final InvoiceDataSource dataSource;

    public InvoiceSaveAllUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Invoice> execute(List<Invoice> invoices){
       return dataSource.save(invoices);
    }

}
