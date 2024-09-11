package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.model.CustomerModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepositoryJpa extends JpaRepository<CategoryModel, String> {

    @EntityGraph(attributePaths = "price")
    List<CategoryModel> findAll();

}
