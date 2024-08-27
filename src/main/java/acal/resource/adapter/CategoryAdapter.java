package acal.resource.adapter;

import acal.report.model.Category;
import acal.resource.model.CategoryModel;

public class CategoryAdapter {
    public static Category map(CategoryModel item){
        return Category
            .builder()
                .number(item.getNumber())
                .name(item.getName())
                .price(PriceAdapter.map(item.getPrice()))
            .build();
    }

    public static CategoryModel map(Category item){
        return CategoryModel
            .builder()
                .number(item.getNumber())
                .name(item.getName())
                .price(PriceAdapter.map(item.getPrice()))
            .build();

    }
}
