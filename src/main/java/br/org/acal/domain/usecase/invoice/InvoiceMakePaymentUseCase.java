package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.InvoicePayment;
import org.springframework.stereotype.Service;

@Service
public class InvoiceMakePaymentUseCase {

    private final InvoiceDataSource dataSource;

    public InvoiceMakePaymentUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void execute(InvoicePayment payment){
        dataSource.makePayment(payment);
    }

}
