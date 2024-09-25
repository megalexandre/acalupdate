package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Category;
import br.org.acal.resouces.model.AddressModel;
import br.org.acal.resouces.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address map(AddressModel address);
    AddressModel map(Address address);

}
