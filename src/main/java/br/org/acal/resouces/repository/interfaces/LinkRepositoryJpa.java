package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.LinkModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;



public interface LinkRepositoryJpa extends JpaRepository<LinkModel, String> {

    List<LinkModel> findByAddressNumber(String addressNumber);

    @Transactional
    @Modifying
    @Query("UPDATE LinkModel l SET l.inactive = false WHERE l.number = :number")
    void active(@Param("number") String number);

    @Transactional
    @Modifying
    @Query("UPDATE LinkModel l SET l.inactive = true WHERE l.number = :number")
    void inactive(@Param("number") String number);

    @EntityGraph(attributePaths = {
        "address",
        "category",
        "category.price",
        "customer",
        "customer.partner",
    }
    )
    @Query(
        "SELECT l FROM LinkModel l " +
            "WHERE NOT EXISTS (" +
            "    SELECT 1 FROM InvoiceModel i " +
            "    WHERE i.link = l " +
            "    AND i.period = :date" +
        ") AND l.inactive = false"
    )
    List<LinkModel> findAllWithoutInvoiceForDate(@Param("date") LocalDateTime date);

}
