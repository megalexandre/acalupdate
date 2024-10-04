package br.org.acal.domain.usecase.link;

import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class LinkDeleteUseCase {

    private final LinkDataSource linkDataSource;

    public LinkDeleteUseCase(LinkDataSource linkDataSource) {
        this.linkDataSource = linkDataSource;
    }

    public void execute(Link link) {
        linkDataSource.inactive(link);
    }

}