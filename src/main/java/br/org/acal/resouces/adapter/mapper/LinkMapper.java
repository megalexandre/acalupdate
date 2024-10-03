package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.Link;
import br.org.acal.resouces.model.LinkModel;
import jakarta.persistence.Column;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CustomerMapper.class})
public interface LinkMapper {

    @Mapping(source = "category", target = "category")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "inactive", target = "active", qualifiedByName = "inactiveToActive")
    Link map(LinkModel linkModel);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "active", target = "inactive", qualifiedByName = "activeToInactive")
    LinkModel map(Link link);

    @Named("inactiveToActive")
    default boolean inactiveToActive(boolean inactive) {
        return !inactive;
    }

    @Named("activeToInactive")
    default boolean activeToInactive(boolean active) {
        return !active;
    }

}
