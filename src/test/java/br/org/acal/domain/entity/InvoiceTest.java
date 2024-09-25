package br.org.acal.domain.entity;

import br.org.acal.resouces.adapter.mapper.InvoiceMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {InvoiceMapper.class})
class InvoiceTest {

    @Test
    void test(){

        InvoiceMapper invoiceMapper = Mappers.getMapper(InvoiceMapper.class);

        val invoice = Invoice.builder().dueDate(LocalDateTime.now()).build();
        val invoiceEntity = invoiceMapper.map(invoice);

        assertEquals(invoiceEntity.getDueDate(), invoice.getDueDate());
    }

}