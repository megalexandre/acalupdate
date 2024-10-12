package br.org.acal.domain.usecase.invoice;

import br.org.acal.domain.datasource.LinkDataSource;
import br.org.acal.domain.entity.CreateInvoice;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.Link;
import br.org.acal.domain.entity.Period;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Comparator.comparing;

@Service
public class CreateInvoiceUseCase {

    private final LinkDataSource dataSource;

    public CreateInvoiceUseCase(LinkDataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<CreateInvoice> execute(Period period){
        val links = dataSource.findAllWithoutInvoiceForDate(period).stream().sorted(
            comparing((Link it) -> it.getAddress().getDisplayName())
                    .thenComparing(Link::getLinkNumber)
        ).toList();

        return links.stream().map(link -> CreateInvoice.builder()
            .invoice(createInvoice(link))
            .link(link)
            .build()
        ).toList();
    }

    private Invoice createInvoice(Link link){
        return Invoice.builder()
                .payedAt(null)
                .createdAt(LocalDateTime.now())
                .link(link)
                .partnerValue(link.getCategory().getPrice().getPartnerValue())
                .otherValues(link.getCategory().getPrice().getValue())

            .build();
    }

}
