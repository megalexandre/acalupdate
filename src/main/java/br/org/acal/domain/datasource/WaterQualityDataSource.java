package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.WaterQuality;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface WaterQualityDataSource {

    List<WaterQuality> find(List<LocalDate> duoDate);
    List<WaterQuality> findAll();
    List<WaterQuality> save(List<WaterQuality> items);
}
