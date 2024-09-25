package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.Link;
import br.org.acal.resouces.model.LinkModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CustomerMapper.class})
public interface LinkMapper {

    @Mapping(source = "category", target = "category")
    @Mapping(source = "customer", target = "customer")
    Link map(LinkModel linkModel);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "customer", target = "customer")
    LinkModel map(Link link);

}
