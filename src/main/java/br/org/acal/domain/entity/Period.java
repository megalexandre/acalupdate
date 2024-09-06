package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static java.lang.StringTemplate.STR;

@Data
@Builder
public class Period {
    private int year;
    private Month month;

    public static Period of(LocalDateTime localDateTime){
        return Period.builder().month(localDateTime.getMonth()).year(localDateTime.getYear()).build();
    }

    public static Period of(LocalDate localDate){
        return Period.builder().month(localDate.getMonth()).year(localDate.getYear()).build();
    }

}
