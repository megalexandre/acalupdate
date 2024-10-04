package br.org.acal.domain.usecase.link;

import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import org.springframework.stereotype.Service;

@Service
public class LinkActiveUseCase {

    private final LinkDataSource linkDataSource;

    public LinkActiveUseCase(LinkDataSource linkDataSource) {
        this.linkDataSource = linkDataSource;
    }

    public void execute(Link link) {
        linkDataSource.active(link);
    }

}