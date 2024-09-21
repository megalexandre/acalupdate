package br.org.acal.domain.model;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.entity.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.time.Month;
import java.util.Optional;

@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceFilter {

    private StatusPaymentInvoice status;
    private String number;
    private String selectedAddress;
    private String selectedCategory;
    private String selectedCustomer;
    private String period;
    private Pageable pageable;
    public Optional<StatusPaymentInvoice> status(){
        return Optional.ofNullable(status);
    }
    public Optional<String> selectedAddress(){
        return Optional.ofNullable(selectedAddress);
    }
    public Optional<String> selectedCategory(){
        return Optional.ofNullable(selectedCategory);
    }
    public Optional<String> selectedCustomer(){
        return Optional.ofNullable(selectedCustomer);
    }
    public Optional<String> selectedNumber(){
        return Optional.ofNullable(number);
    }
    public Optional<Pageable> pageable(){
        return Optional.ofNullable(pageable);
    }
    public Optional<Period> period(){

        try {
            var values = period.split("/");
            var month = Month.of(Integer.parseInt(values[0]));
            var year = (Integer.parseInt(values[1]));
            return Optional.of(Period.builder().year(year).month(month).build());
        } catch (Exception e){
            return Optional.empty();
        }

    }
}
