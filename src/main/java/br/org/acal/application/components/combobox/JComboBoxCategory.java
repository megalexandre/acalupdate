package br.org.acal.application.components.combobox;

import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.domain.entity.Category;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class JComboBoxCategory extends JComboBoxDefault{

    private String number;
    private String name;
    private Category category;

    public static JComboBoxCategory of(Category category){
        return JComboBoxCategory.builder()
            .category(category)
            .number(category.getNumber())
            .name(category.getName())
            .build();
    }


    public static JComboBoxCategory clearData(){
        return JComboBoxCategory.builder().
            number(EMPTY).
            name(SELECT)
        .build();
    }

    @Override
    public String toString() {

        if(category == null){
            return name;
        }

        String firstPart = category.getName() + "/" + category.getGroup().getDescription();
        String secondPart = String.format("[%s, %s]",
                BigDecimalUtil.asString(category.getPrice().getValue()),
                BigDecimalUtil.asString(category.getPrice().getPartnerValue()));

        int spacesNeeded = 150 - firstPart.length();

        return firstPart + String.format("%" + spacesNeeded + "s", "") + secondPart;
    }

}