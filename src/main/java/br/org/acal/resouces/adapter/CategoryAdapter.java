package br.org.acal.resouces.adapter;

import br.org.acal.commons.enumeration.Group;
import br.org.acal.domain.entity.Category;
import br.org.acal.resouces.model.CategoryModel;

public class CategoryAdapter {
    public static Category map(CategoryModel item){
        return Category
            .builder()
                .number(item.getNumber())
                .name(item.getName())
                .price(PriceAdapter.map(item.getPrice()))
                .group(Group.fromNumber(item.getGroup()))
            .build();
    }

    public static CategoryModel map(Category item){
        return CategoryModel
            .builder()
                .number(item.getNumber())
                .name(item.getName())
                .price(PriceAdapter.map(item.getPrice()))
                .group(item.getNumber())
            .build();

    }
}
