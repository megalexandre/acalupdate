package acal.report.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Invoice {

    private String number;
    private LocalDateTime payedAt;
    private LocalDateTime duoDate;
    private LocalDateTime createdAt;
    private LocalDateTime period;
    private Link link;

    public Customer customer() {
        return link.getCustomer();
    }

    public Address address(){
        return link.getAddress();
    }

}
