package br.org.acal.application.screen.link.model;

import br.org.acal.domain.entity.Link;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static br.org.acal.commons.util.LocalDateTimeUtil.dateTime;

@Data
@Builder
public class LinkTable {

    private String number;
    private String name;
    private String address;
    private String category;
    private String group;
    private String inactive;
    public static LinkTable of(Link link){
        return LinkTable.builder()
                .number(link.getLinkNumber())
                .address(link.getAddress().getDisplayName())
                .name(link.getCustomer().getName())
                .category(link.getCategory().getName())
                .group(link.getCategory().getGroup().getDescription())
                .inactive(link.getInactive() ? "Inativo": "Ativo")
                .build();
    }
}


