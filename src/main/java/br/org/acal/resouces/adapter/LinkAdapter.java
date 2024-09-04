package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Link;
import br.org.acal.resources.model.LinkModel;

public class LinkAdapter {
    public static Link map(LinkModel item){
        return Link
            .builder()
                .number(item.getNumber())
                .address(AddressAdapter.map(item.getAddress()) )
                .customer(CustomerAdapter.map(item.getCustomer()))
                .partnerNumber(item.getPartnerNumber())
                .category(CategoryAdapter.map(item.getCategory()))
            .build();
    }

    public static LinkModel map(Link item){
        return LinkModel
            .builder()
                .number(item.getNumber())
                .address(AddressAdapter.map(item.getAddress()) )
                .partnerNumber(item.getPartnerNumber())
                .customer(CustomerAdapter.map(item.getCustomer()))
                .category(CategoryAdapter.map(item.getCategory()))
            .build();

    }
}
