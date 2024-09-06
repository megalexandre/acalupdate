package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.InvoiceModel;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InvoiceRepositoryJpa extends JpaRepository<InvoiceModel, String> {

    List<InvoiceModel> findTop1ByPayedAtIsNull();

}

