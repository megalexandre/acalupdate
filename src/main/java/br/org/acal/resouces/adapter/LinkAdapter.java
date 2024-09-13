package br.org.acal.resouces.adapter;

import br.org.acal.domain.entity.Link;
import br.org.acal.resouces.model.LinkModel;

public class LinkAdapter {
    public static Link map(LinkModel item){
        return Link
            .builder()
                .number(item.getNumber())
                .address(AddressAdapter.map(item.getAddress()) )
                .customer(CustomerAdapter.map(item.getCustomer()))
                .linkNumber(item.getLinkNumber())
                .inactive(item.getInactive())
                .category(CategoryAdapter.map(item.getCategory()))
            .build();
    }

    public static LinkModel map(Link item){
        return LinkModel
            .builder()
                .number(item.getNumber())
                .address(AddressAdapter.map(item.getAddress()) )
                .linkNumber(item.getLinkNumber())
                .inactive(item.getInactive())
                .customer(CustomerAdapter.map(item.getCustomer()))
                .category(CategoryAdapter.map(item.getCategory()))
            .build();

    }
}
