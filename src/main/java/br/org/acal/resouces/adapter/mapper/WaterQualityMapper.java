package br.org.acal.resouces.adapter.mapper;

import br.org.acal.commons.enumeration.WaterQualityParameter;
import br.org.acal.domain.entity.WaterParam;
import br.org.acal.domain.entity.WaterQuality;
import br.org.acal.resouces.model.WaterQualityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface WaterQualityMapper {

    @Mapping(source = "param", target = "waterParam", qualifiedByName = "mapWaterQualityParameterFromNumber")
    WaterQuality map(WaterQualityModel model);

    @Mapping(source = "waterParam", target = "param", qualifiedByName = "mapWaterQualityParameterToNumber")
    WaterQualityModel map(WaterQuality entity);

    @Named("mapWaterQualityParameterFromNumber")
    default WaterParam mapWaterQualityParameterFromNumber(String param) {
        return WaterQualityParameter.fromNumber(param);
    }

    @Named("mapWaterQualityParameterToNumber")
    default String mapWaterQualityParameterToNumber(WaterParam param) {
        return param != null ? param.getNumber() : null;
    }
}