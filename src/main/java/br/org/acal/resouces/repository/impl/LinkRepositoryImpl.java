package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.model.FindLink;
import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.resouces.repository.interfaces.LinkRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class LinkRepositoryImpl implements LinkDataSource {
    private final LinkRepositoryJpa linkRepositoryJpa;
    public LinkRepositoryImpl(LinkRepositoryJpa linkRepositoryJpa){
        this.linkRepositoryJpa = linkRepositoryJpa;
    }

    @Override
    public boolean exists(FindLink findLink) {
        return !linkRepositoryJpa.findByAddressNumber(findLink.getAddressId()).isEmpty();
    }
}
