package br.org.acal.domain.entity;

import br.org.acal.commons.util.StringUtil;
import lombok.Builder;
import lombok.Data;
import lombok.val;

@Data
@Builder
public class Document {

    private String type;
    private String number;

    public static Document of(String value){
        val number = StringUtil.clean(value);

        return Document.builder()
                .number(StringUtil.clean(number))
                .type(number.length() == 11? "CPF" : "CPNJ")
                .build();

    }

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

