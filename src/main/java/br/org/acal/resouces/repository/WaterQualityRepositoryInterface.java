package br.org.acal.resouces.repository;

import br.org.acal.resouces.model.WaterQualityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterQualityRepositoryInterface extends JpaRepository<WaterQualityModel, String> {

}
