package br.org.acal.resouces.adapter.mapper;

import br.org.acal.commons.enumeration.Group;
import br.org.acal.domain.entity.Category;
import br.org.acal.domain.entity.Price;
import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.model.PriceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {PriceMapper.class})
public interface CategoryMapper {


    @Mapping(source = "group", target = "group", qualifiedByName = "mapGroupFromString")
    @Mapping(source = "price", target = "price")
    Category map(CategoryModel model);

    @Mapping(source = "group", target = "group", qualifiedByName = "mapGroupToString")
    @Mapping(source = "price", target = "price")
    CategoryModel map(Category entity);
    @Named("mapGroupFromString")
    default Group mapGroupFromString(String groupNumber) {
        return Group.fromNumber(groupNumber);
    }

    @Named("mapGroupToString")
    default String mapGroupToString(Group group) {
        return group.getNumber();
    }
}
