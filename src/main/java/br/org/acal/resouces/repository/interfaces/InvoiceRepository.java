package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, String> { }
