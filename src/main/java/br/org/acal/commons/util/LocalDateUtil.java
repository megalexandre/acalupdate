package br.org.acal.commons.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {

    private static final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String localDateToString(LocalDate localDate){
        if(localDate == null){
            return null;
        }

        return localDate.format(date);
    }

    public static LocalDate stringToLocalDate(String value){

        try {
            return LocalDate.parse(value, date);
        } catch (Exception ignored){
            return null;
        }

    }

}
