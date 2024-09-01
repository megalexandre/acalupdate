package br.org.acal.resouces.repository;

import br.org.acal.resouces.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryInterface extends JpaRepository<AddressModel, String> {
}
