package br.org.acal.application.components.combobox;

import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.commons.util.StringUtil;
import br.org.acal.domain.entity.Category;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.val;

import static br.org.acal.commons.util.BigDecimalUtil.asString;
import static br.org.acal.commons.util.StringUtil.lpad;

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

        val categoryName = category.getName();

        val values = lpad(asString(category.totalValue() ),8, ' ');

        val categoryString = lpad(String.format("[%s] [%s]",
                values,
                lpad( category.getGroup().getDescription(), 20, ' ')
                ),  20, ' ');

        return categoryString +" " + categoryName;
    }

}