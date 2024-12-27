package br.org.acal.commons.util;

import java.math.BigDecimal;
import java.util.Optional;

import static java.text.NumberFormat.getCurrencyInstance;

public class BigDecimalUtil {

    public static String asString(BigDecimal value){
        return Optional.ofNullable(value)
                .map(it -> getCurrencyInstance(DefaultLocale.ptBR()).format(value))
                .orElse("R$ 0,00");
    }

}

