package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.entity.WaterQuality;
import br.org.acal.domain.datasource.WaterQualityDataSource;
import br.org.acal.resouces.adapter.WaterQualityAdapter;
import br.org.acal.resouces.repository.interfaces.WaterQualityRepositoryJpa;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class WaterQualityRepositoryImpl implements WaterQualityDataSource {
    private final WaterQualityRepositoryJpa waterQualityRepository;

    public WaterQualityRepositoryImpl(@Lazy WaterQualityRepositoryJpa waterQualityRepository){
        this.waterQualityRepository = waterQualityRepository;
    }

    public List<WaterQuality> find(List<LocalDate> duoDate) {
        return waterQualityRepository.findAll().stream().map(WaterQualityAdapter::map).toList();
    }

}
