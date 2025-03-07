package br.org.acal.domain.usecase.link;

import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.model.LinkFilter;
import br.org.acal.domain.usecase.Usecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkFindUseCase implements Usecase<LinkFilter, List<Link>> {

    private final LinkDataSource dataSource;

    public LinkFindUseCase(LinkDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Link> execute(LinkFilter linkFilter) {
        return dataSource.find(linkFilter);
    }

}
