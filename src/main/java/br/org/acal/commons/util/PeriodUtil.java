package br.org.acal.commons.util;

import br.org.acal.domain.entity.Period;

import java.time.format.TextStyle;
import java.util.Locale;

public class PeriodUtil {

    public static String formatter(Period period){
        String month = period.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        return String.format("%02d", period.getMonth().ordinal() + 1) + "/" +  period.getYear() + " ("+ month +")";
    }
}
