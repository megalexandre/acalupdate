package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.WaterMeterModel;
import br.org.acal.resouces.model.WaterQualityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterMeterRepositoryJpa extends JpaRepository<WaterMeterModel, String> {}
