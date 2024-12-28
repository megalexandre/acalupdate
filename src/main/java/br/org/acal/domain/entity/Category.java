package br.org.acal.domain.entity;

import br.org.acal.commons.enumeration.Group;
import br.org.acal.commons.util.BigDecimalUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.Normalizer;

@Data
@Builder
public class Category {

    private String number;
    private String name;
    private Price price;
    private Group group;

    public BigDecimal totalValue(){
        return price.getValue().add(price.getPartnerValue());
    }

    public boolean isHydrometer(){
        return Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase().contains("hidrometro");
    }
}
