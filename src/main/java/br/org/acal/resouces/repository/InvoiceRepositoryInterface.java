package br.org.acal.resouces.repository;

import br.org.acal.resouces.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepositoryInterface extends JpaRepository<InvoiceModel, String> {
}
