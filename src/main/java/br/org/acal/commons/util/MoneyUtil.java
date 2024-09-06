package br.org.acal.commons.util;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyUtil {

    public static NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

}
