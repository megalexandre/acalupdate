package br.org.acal.commons.util;

public class StringUtil {

    public static String clean(String string){
        if (string == null) {
            return null;
        }
        return string.replaceAll("[^0-9]", "");
    }

    public static String lpad(String str, int length, char padChar) {

        if (str.length() >= length) {
            return str;
        }

        int paddingLength = length - str.length();

        return str + String.valueOf(padChar).repeat(paddingLength) ;
    }
}
