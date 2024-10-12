package br.org.acal.application.screen.link.model;

import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Category;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.entity.Link;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkCreateRequest {

    @NotEmpty(message =  "O número da ligação é obrigatorio")
    private String linkNumber;

    @NotNull(message = "O Usúario não pode ser nulo")
    private Customer customer;

    @NotNull(message = "O endereço não pode ser nulo")
    private Address address;

    @NotNull(message = "O categoria não pode ser nulo")
    private Category category;

    private Boolean exclusiveMember;

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
