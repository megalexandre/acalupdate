package br.org.acal.application.components.combobox;

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
        return name;
    }

}