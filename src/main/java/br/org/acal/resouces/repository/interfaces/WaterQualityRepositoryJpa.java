package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.WaterQualityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterQualityRepositoryJpa extends JpaRepository<WaterQualityModel, String> {}
