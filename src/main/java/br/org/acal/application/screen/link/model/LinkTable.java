package br.org.acal.application.screen.link.model;

import br.org.acal.domain.entity.Link;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkTable {

    private String number;
    private String name;
    private String address;
    private String category;
    private String group;
    private String active;
    private Link link;

    public static LinkTable of(Link link){
        return LinkTable.builder()
                .number(link.getLinkNumber())
                .address(link.getAddress().getDisplayName())
                .name(link.getCustomer().getName())
                .category(link.getCategory().getName())
                .group(link.getCategory().getGroup().getDescription())
                .active(link.getActive() ? "Ativo": "Inativo" )
                .link(link)
                .build();
    }
}


