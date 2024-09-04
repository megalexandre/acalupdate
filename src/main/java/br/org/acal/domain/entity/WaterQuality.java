package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class WaterQuality {

    private String number;
    private WaterParam waterParam;
    private String required;
    private String analyzed;
    private String accordance;
    private LocalDate date;

    public Period period(){
        return Period.of(date);
    }

}
