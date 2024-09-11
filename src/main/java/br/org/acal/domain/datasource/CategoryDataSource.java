package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Category;

import java.util.List;

public interface CategoryDataSource {

    List<Category> findAll();

}
