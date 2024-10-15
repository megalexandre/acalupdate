package br.org.acal.domain.usecase.register;

import br.org.acal.domain.datasource.PaymentDataSource;
import br.org.acal.domain.entity.Payment;
import br.org.acal.domain.model.PaymentFilter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PaymentPaginateUseCase {

    private final PaymentDataSource dataSource;

    public PaymentPaginateUseCase(PaymentDataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Payment> execute(PaymentFilter filter) {
        return dataSource.paginate(filter).stream().sorted(Comparator.comparing(Payment::getNumber)).toList();
    }

}
