package br.org.acal.domain.repository;

import br.org.acal.domain.model.WaterQuality;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface WaterQualityDataSource {
    List<WaterQuality> find(List<LocalDate> duoDate);
}
