package acal.report.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Customer {

    private String number;
    private String name;

}
