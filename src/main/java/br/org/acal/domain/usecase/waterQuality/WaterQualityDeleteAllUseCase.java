package br.org.acal.domain.usecase.waterQuality;

import br.org.acal.domain.datasource.WaterQualityDataSource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WaterQualityDeleteAllUseCase {

    private final WaterQualityDataSource dataSource;

    public WaterQualityDeleteAllUseCase(WaterQualityDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void execute(LocalDate date) {
        dataSource.delete(date);
    }

}
