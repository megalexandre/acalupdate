package br.org.acal.commons;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {
    public static final DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static final DateTimeFormatter period = DateTimeFormatter.ofPattern("MMMM/yyyy");
    public static final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
