package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryJpa extends JpaRepository<CustomerModel, String> {
}
