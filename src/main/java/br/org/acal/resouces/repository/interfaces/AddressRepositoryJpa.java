package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.AddressModel;
import br.org.acal.resouces.model.InvoiceModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AddressRepositoryJpa extends JpaRepository<AddressModel, String> {

    @Query(
        "SELECT address " +
            "FROM AddressModel address " +
        "WHERE " +
            "(:number IS NULL OR address.number = :number) AND " +
            "(:name IS NULL OR address.name = :name) AND " +
            "(:type IS NULL OR address.type = :type)"
)
    List<AddressModel> find(
        @Param("number") String number,
        @Param("name") String name,
        @Param("type") String type,
        Sort sort
    );

}
