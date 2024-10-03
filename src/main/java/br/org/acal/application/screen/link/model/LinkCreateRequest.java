package br.org.acal.application.screen.link.model;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Category;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkCreateRequest {

    @NotNull("O número da ligação é obrigatorio")
    private String linkNumber;

    @NotNull("O Usúario não pode ser nulo")
    private Customer customer;

    @NotNull("O endereço não pode ser nulo")
    private Address address;

    @NotNull("O categoria não pode ser nulo")
    private Category category;

    private Boolean exclusiveMember;

    public boolean isValid(){
        return customer!= null;
    }


    public Link toLink(){
        return Link.builder()
                .exclusiveMember(exclusiveMember)
                .linkNumber(linkNumber)
                .customer(customer)
                .address(address)
                .category(category)
                .active(true)
                .build();
    }

}
