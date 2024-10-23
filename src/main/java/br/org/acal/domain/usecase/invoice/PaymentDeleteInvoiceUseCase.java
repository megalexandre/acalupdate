package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.InvoiceDataSource;
import org.springframework.stereotype.Service;

@Service
public class PaymentDeleteInvoiceUseCase {

    private final InvoiceDataSource dataSource;

    public PaymentDeleteInvoiceUseCase(InvoiceDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void execute(String number){
        dataSource.deletePayment(number);
    }

}
