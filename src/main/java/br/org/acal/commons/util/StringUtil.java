package br.org.acal.commons.util;

public class StringUtil {
    public static String clean(String string){
        if (string == null) {
            return null;
        }
        return string.replaceAll("[^0-9]", "");
    }
}
