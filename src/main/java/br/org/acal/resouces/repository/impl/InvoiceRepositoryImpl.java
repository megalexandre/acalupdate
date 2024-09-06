package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.FindInvoice;
import br.org.acal.domain.datasource.InvoiceDataSource;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.resouces.adapter.InvoiceAdapter;
import br.org.acal.resouces.repository.interfaces.InvoiceRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepositoryImpl implements InvoiceDataSource {
    private final InvoiceRepositoryJpa repositoryJpa;

    public InvoiceRepositoryImpl(InvoiceRepositoryJpa repositoryJpa){
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public List<Invoice> find(FindInvoice findInvoice) {
        return repositoryJpa.findAll().stream().map(InvoiceAdapter::map).toList();
    }

    @Override
    public List<Invoice> findAll() {
        return repositoryJpa.findByPayedAtIsNull().stream().map(InvoiceAdapter::map).toList();
    }
}
