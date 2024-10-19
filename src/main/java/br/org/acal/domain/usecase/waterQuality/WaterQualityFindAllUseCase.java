package br.org.acal.domain.usecase.waterQuality;

import br.org.acal.domain.datasource.WaterQualityDataSource;
import br.org.acal.domain.entity.WaterQuality;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class WaterQualityFindAllUseCase {

    private final WaterQualityDataSource dataSource;

    public WaterQualityFindAllUseCase(WaterQualityDataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<WaterQuality> execute() {
        return dataSource.findAll().stream().sorted(Comparator.comparing(WaterQuality::getDate).reversed()).toList();
    }

}
