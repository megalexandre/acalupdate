package br.org.acal.domain.usecase.link;

import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.model.LinkFilter;
import lombok.val;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class LinkCreateUseCase {

    private final LinkDataSource linkDataSource;
    private final MessageSource messageSource;

    public LinkCreateUseCase(LinkDataSource linkDataSource, MessageSource messageSource) {
        this.linkDataSource = linkDataSource;
        this.messageSource = messageSource;
    }

    public Link execute(Link link) {
       // assertDuoDate(link);
        assertDuplicationAddress(link);
        return linkDataSource.save(link);
    }

    private void assertDuoDate(Link link) {
        LinkFilter filter = LinkFilter.builder()
            .linkNumber(link.getLinkNumber())
            .addressNumber(link.getAddress().getNumber())
            .isPayed(false)
            .build();

        List<Link> nonPayedLinks = linkDataSource.find(filter);

        if (!nonPayedLinks.isEmpty()) {
            throw new RuntimeException(
                messageSource.getMessage("link.no-payed", null, Locale.getDefault())
            );
        }
    }

    private void assertDuplicationAddress(Link link) {
        LinkFilter filter = LinkFilter.builder()
            .addressNumber(link.getAddress().getNumber())
            .linkNumber(link.getLinkNumber())
            .active(true)
            .build();

        List<Link> activeLinks = linkDataSource.find(filter);
        if (!activeLinks.isEmpty()) {
            val active = activeLinks.stream().findFirst().orElseThrow();

            Object[] params = {
                active.getLinkNumber(),
                active.getAddress().getDisplayName(),
                active.getCustomer().getName()
            };
            throw new RuntimeException(
                messageSource.getMessage("link.duplicate.address", params,  Locale.of("pt", "BR"))
            );
        }
    }
}