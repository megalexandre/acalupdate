package acal.report.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private String number;
    private String name;
    private Price price;

}
