package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.WaterQualityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface WaterQualityRepositoryJpa extends JpaRepository<WaterQualityModel, String> {

    List<WaterQualityModel> findAllByDateIn(List<LocalDate> dates);

    @Transactional
    void deleteAllByDate(LocalDate date);

}
