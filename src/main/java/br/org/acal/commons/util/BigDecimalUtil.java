package br.org.acal.commons.util;

import java.math.BigDecimal;
import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;

public class BigDecimalUtil {

    public static String asString(BigDecimal value){
        return value == null ? "R$ 0,00" : getCurrencyInstance(Locale.of("pt", "BR")).format(value);
    }

}

