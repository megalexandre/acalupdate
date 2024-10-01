package br.org.acal.domain.usecase.link;

import br.org.acal.domain.entity.Link;
import org.springframework.stereotype.Service;

@Service
public class LinkCreateUseCase {

    public Link execute(Link link) {
        return link;
    }



}
