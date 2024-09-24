package br.org.acal.domain.datasource;

import java.text.DecimalFormat;

public class DecimalFormatUtil {
    private static final  DecimalFormat defaultFormat = new DecimalFormat("#,###.##");
    public static String format(Double value){
        return defaultFormat.format(value);
    }

}
