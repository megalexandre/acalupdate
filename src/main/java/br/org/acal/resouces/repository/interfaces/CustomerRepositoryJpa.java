package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.CustomerModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepositoryJpa extends JpaRepository<CustomerModel, String> {
    @EntityGraph(attributePaths = "partner")
    List<CustomerModel> findAllByOrderByNameAsc();

}
