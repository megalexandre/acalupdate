package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {

    private String type;
    private String number;

    public String documentNumber() {
        if (number == null) {
            return "";
        }

        if (number.length() == 11) {
            return number.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        } else if (number.length() == 14) {
            return number.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        } else {
            return number;
        }
    }

}

