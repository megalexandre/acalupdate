package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Link;
import br.org.acal.domain.model.FindLink;
import br.org.acal.domain.model.LinkFind;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LinkDataSource {

    boolean exists(FindLink findLink);
    List<Link> find(LinkFind findLink);
    List<Link> findAll();

}
