package br.org.acal.domain.usecase.category;

import br.org.acal.domain.datasource.CategoryDataSource;
import br.org.acal.domain.entity.Category;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryFindAllUseCase implements Usecase<Void, List<Category>> {
    private final CategoryDataSource dataSource;

    public CategoryFindAllUseCase(CategoryDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> execute(Void unused) {
        return dataSource.findAll();
    }
}
