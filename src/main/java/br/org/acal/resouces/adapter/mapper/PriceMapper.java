package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.Price;
import br.org.acal.resouces.model.PriceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    Price map(PriceModel priceModel);
    PriceModel map(Price price);

}
