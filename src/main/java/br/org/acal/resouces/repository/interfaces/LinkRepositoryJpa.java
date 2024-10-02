package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface LinkRepositoryJpa extends JpaRepository<LinkModel, String> {
    List<LinkModel> findByAddressNumber(String addressNumber);
}
