package br.org.acal.commons.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class LocalDateTimeUtil {

    public static final DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static final DateTimeFormatter period = DateTimeFormatter.ofPattern("MMMM/yyyy");
    public static final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDateTime stringToLocalDateTime(String value) {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay();
    }

    public static String localDateToString(LocalDateTime localDateTime){
        return Optional.ofNullable(localDateTime)
                .map(data -> localDateTime.format(date))
                .orElse("");
    }

}
