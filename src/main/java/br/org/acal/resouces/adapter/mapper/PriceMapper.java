package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.Price;
import br.org.acal.resouces.model.PriceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface PriceMapper {


    @Mapping(target = "value", qualifiedByName = "mapToZeroIfNull")
    @Mapping(target = "partnerValue", qualifiedByName = "mapToZeroIfNull")
    Price map(PriceModel priceModel);

    @Mapping(target = "value", qualifiedByName = "mapToZeroIfNull")
    @Mapping(target = "partnerValue", qualifiedByName = "mapToZeroIfNull")
    PriceModel map(Price price);

    @Named("mapToZeroIfNull")
    default BigDecimal mapToZeroIfNull(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
}
