package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.datasource.CategoryDataSource;
import br.org.acal.domain.entity.Category;
import br.org.acal.resouces.adapter.CategoryAdapter;
import br.org.acal.resouces.model.CategoryModel;
import br.org.acal.resouces.repository.interfaces.CategoryRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryDataSource {
    private final CategoryRepositoryJpa repositoryJpa;
    public CategoryRepositoryImpl(CategoryRepositoryJpa repositoryJpa){
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public List<Category> findAll() {
        return repositoryJpa.findAll().stream()
                .sorted(Comparator.comparing(CategoryModel::getName))
                .map(CategoryAdapter::map).toList();
    }
}
