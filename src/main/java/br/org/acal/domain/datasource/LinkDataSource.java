package br.org.acal.domain.datasource;

import br.org.acal.domain.FindLink;
import org.springframework.stereotype.Component;

@Component
public interface LinkDataSource {

    boolean exists(FindLink findLink);

}