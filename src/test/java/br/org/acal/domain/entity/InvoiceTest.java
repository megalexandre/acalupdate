package br.org.acal.domain.entity;

import br.org.acal.resouces.adapter.InvoiceMapper;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {InvoiceMapper.class})
class InvoiceTest {

    @Test
    void test(){

        InvoiceMapper invoiceMapper = Mappers.getMapper(InvoiceMapper.class);

        val now = LocalDateTime.now();
        val invoice = Invoice.builder().dueDate(LocalDateTime.now()).build();

        val invoiceEntity = invoiceMapper.map(invoice);

        assertEquals(invoiceEntity.getDueDate(), invoice.getDueDate());
    }

}