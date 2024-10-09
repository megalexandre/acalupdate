package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.Link;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.model.LinkFilter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface LinkDataSource extends DefaultDataSource<Link> {

    boolean exists(LinkFilter LinkFilter);
    List<Link> find(LinkFilter findLink);

    void active(Link link);
    void inactive(Link link);

    List<Link> findAllWithoutInvoiceForDate(Period period);
}
