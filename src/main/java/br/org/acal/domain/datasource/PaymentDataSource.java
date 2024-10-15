package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Payment;
import br.org.acal.domain.model.PaymentFilter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentDataSource {

    List<Payment> paginate(PaymentFilter filter);

}
