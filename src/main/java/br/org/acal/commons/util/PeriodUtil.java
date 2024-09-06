package br.org.acal.commons.util;

import br.org.acal.domain.entity.Period;

import java.time.format.TextStyle;
import java.util.Locale;

public class PeriodUtil {

    public static String formatter(Period period){
        String month = period.getMonth().getDisplayName(TextStyle.FULL, Locale.of("pt", "BR"));
        return month + "/" +  period.getYear();
    }
}
