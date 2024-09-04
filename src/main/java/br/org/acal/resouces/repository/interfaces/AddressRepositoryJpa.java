package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resources.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryJpa extends JpaRepository<AddressModel, String> {
}
