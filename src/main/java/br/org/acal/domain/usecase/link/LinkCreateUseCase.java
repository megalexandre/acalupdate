package br.org.acal.domain.usecase.link;

import br.org.acal.commons.enumeration.Group;
import br.org.acal.commons.util.DefaultLocale;
import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.model.LinkFilter;
import lombok.val;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class LinkCreateUseCase {

    private final LinkDataSource linkDataSource;
    private final MessageSource messageSource;

    public LinkCreateUseCase(LinkDataSource linkDataSource, MessageSource messageSource) {
        this.linkDataSource = linkDataSource;
        this.messageSource = messageSource;
    }

    public Link execute(Link link) {
        assertDuplicationAddress(link);
        return linkDataSource.save(link);
    }

    private void assertDuplicationAddress(Link link) {
        avoidDuplicateLinkNumber(link);
        avoidMultipleFunderOrPartner(link);
    }

    private void avoidMultipleFunderOrPartner(Link link) {
        List<Link> activeLinksByCustomer = linkDataSource.find(LinkFilter.builder()
            .customerId(link.getCustomer().getNumber())
            .active(true)
            .build());

        var groups = Stream.concat(
                activeLinksByCustomer.stream().map(it -> it.getCategory().getGroup()),
                Stream.of(link.getCategory().getGroup())
        ).toList();

        checkGroupDuplication(groups, Group.EFFECTIVE, "link.duplicate.group.effective");
        checkGroupDuplication(groups, Group.FOUNDER, "link.duplicate.group.founder");
    }

    private void checkGroupDuplication(List<Group> groups, Group group, String messageKey) {
        if (groups.stream().filter(it -> it.equals(group)).count() > 1) {
            throw new RuntimeException(
                    messageSource.getMessage(messageKey, new Object[]{}, DefaultLocale.ptBR())
            );
        }
    }

    private void avoidDuplicateLinkNumber(Link link) {
        List<Link> activeLinks = linkDataSource.find(LinkFilter.builder()
                .linkNumber(link.getLinkNumber())
                .active(true)
                .build());

        if (!activeLinks.isEmpty()) {
            val active = activeLinks.stream().findFirst().orElseThrow();

            Object[] params = {
                    active.getLinkNumber(),
                    active.getAddress().getDisplayName(),
                    active.getCustomer().getName()
            };

            throw new RuntimeException(
                messageSource.getMessage("link.duplicate.address", params, DefaultLocale.ptBR())
            );
        }

    }

}