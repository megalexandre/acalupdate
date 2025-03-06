package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.datasource.WaterQualityDataSource;
import br.org.acal.domain.entity.WaterQuality;
import br.org.acal.resouces.adapter.mapper.WaterQualityMapper;
import br.org.acal.resouces.repository.interfaces.WaterQualityRepositoryJpa;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class WaterQualityRepositoryImpl implements WaterQualityDataSource {

    private final WaterQualityRepositoryJpa waterQualityRepository;
    private final WaterQualityMapper waterQualityMapper;

    public WaterQualityRepositoryImpl(
            @Lazy WaterQualityRepositoryJpa waterQualityRepository,
            WaterQualityMapper waterQualityMapper){

        this.waterQualityRepository = waterQualityRepository;
        this.waterQualityMapper = waterQualityMapper;
    }

    public List<WaterQuality> find(List<LocalDate> date) {
        return waterQualityRepository.findAllByDateIn(date)
                .stream().map(waterQualityMapper::map).toList();
    }

    @Override
    public List<WaterQuality> findAll() {
        return waterQualityRepository.findAll().stream().map(waterQualityMapper::map).toList();
    }

    @Override
    public List<WaterQuality> save(List<WaterQuality> items) {
        return waterQualityRepository
                .saveAll(items.stream().map( waterQualityMapper::map).toList())
                .stream().map(waterQualityMapper::map).toList();
    }

    @Override
    public void delete(LocalDate date) {
        waterQualityRepository.deleteAllByDate(date);
    }

}
