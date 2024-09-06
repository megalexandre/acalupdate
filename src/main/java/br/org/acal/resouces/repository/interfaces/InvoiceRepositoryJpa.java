package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.InvoiceModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepositoryJpa extends JpaRepository<InvoiceModel, String> {

    @EntityGraph(attributePaths = {
        "link",
        "link.address",
        "link.category", "link.category.price",
        "link.customer", "link.customer.partner",
        "waterMeter"
        }
    )
    List<InvoiceModel> findByPayedAtIsNull();

}

