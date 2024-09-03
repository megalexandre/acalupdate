package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.FindLink;
import br.org.acal.domain.repository.LinkDataSource;
import br.org.acal.resouces.repository.interfaces.LinkRepositoryB;
import org.springframework.stereotype.Repository;

@Repository
public class LinkRepositoryImpl implements LinkDataSource {
    private final LinkRepositoryB linkRepositoryB;
    public LinkRepositoryImpl(LinkRepositoryB linkRepositoryB){
        this.linkRepositoryB = linkRepositoryB;
    }

    @Override
    public boolean exists(FindLink findLink) {
        return !linkRepositoryB.findByAddressNumber(findLink.getAddressId()).isEmpty();
    }
}
