package br.org.acal.domain.usecase.link

import br.org.acal.domain.entity.Link
import org.springframework.stereotype.Service

@Service
class LinkCreateUseCase() {

    fun execute(link: Link): Link {


        return link
    }
}
