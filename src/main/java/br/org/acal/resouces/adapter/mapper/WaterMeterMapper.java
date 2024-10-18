package br.org.acal.resouces.adapter.mapper;

import br.org.acal.domain.entity.WaterMeter;
import br.org.acal.resouces.model.InvoiceModel;
import br.org.acal.resouces.model.WaterMeterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface WaterMeterMapper {

    @Mapping(source = "number", target = "number", qualifiedByName = "defaultString")
    @Mapping(source = "consumptionStart", target = "consumptionStart", qualifiedByName = "defaultDouble")
    @Mapping(source = "consumptionEnd", target = "consumptionEnd", qualifiedByName = "defaultDouble")
    WaterMeter map(WaterMeterModel model);

    @Mapping(source = "number", target = "number", qualifiedByName = "defaultString")
    @Mapping(source = "consumptionStart", target = "consumptionStart", qualifiedByName = "defaultDouble")
    @Mapping(source = "consumptionEnd", target = "consumptionEnd", qualifiedByName = "defaultDouble")
    @Mapping(source = "invoiceNumber", target = "invoice.number")
    WaterMeterModel map(WaterMeter entity);

    @Named("defaultString")
    default String defaultString(String value) {
        return value != null ? value : "";
    }

    @Named("defaultDouble")
    default Double defaultDouble(Double value) {
        return value != null ? value : 0d;
    }

}