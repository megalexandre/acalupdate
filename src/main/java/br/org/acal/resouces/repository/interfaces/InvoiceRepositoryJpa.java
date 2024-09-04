package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resources.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepositoryJpa extends JpaRepository<InvoiceModel, String> { }
