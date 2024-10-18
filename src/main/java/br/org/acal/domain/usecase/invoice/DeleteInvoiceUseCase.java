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

import static java.util.Comparator.comparing;

@Service
public class DeleteInvoiceUseCase {

    private final InvoiceDataSource dataSource;

    public DeleteInvoiceUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void execute(String number){
        dataSource.delete(number);
    }

}
