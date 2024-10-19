package br.org.acal.domain.usecase.waterQuality;

import br.org.acal.domain.datasource.WaterQualityDataSource;
import br.org.acal.domain.entity.WaterQuality;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterQualitySaveAllUseCase {

    private final WaterQualityDataSource dataSource;

    public WaterQualitySaveAllUseCase(WaterQualityDataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<WaterQuality> execute(List<WaterQuality> items) {
        return dataSource.save(items);
    }

}
