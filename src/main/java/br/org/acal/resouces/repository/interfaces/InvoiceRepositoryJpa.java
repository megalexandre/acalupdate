package br.org.acal.resouces.repository.interfaces;

import br.org.acal.resouces.model.InvoiceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Query(
        " SELECT invoice " +
            " FROM InvoiceModel invoice " +
        " LEFT JOIN FETCH invoice.waterMeter waterMeter " +
        " LEFT JOIN FETCH invoice.link link " +
        " LEFT JOIN FETCH link.customer customer " +
        " LEFT JOIN FETCH customer.partner partner " +
        " LEFT JOIN FETCH link.address address " +
        " LEFT JOIN FETCH link.category category " +
        " LEFT JOIN FETCH category.price price " +
        " WHERE " +
            "(:selectedCustomer IS NULL OR customer.number = :selectedCustomer ) AND " +
            "(:selectedCategory IS NULL OR category.number = :selectedCategory ) AND " +
            "(:selectedAddress IS NULL OR address.number = :selectedAddress ) AND" +
            "(:periodStart IS NULL OR invoice.period BETWEEN :periodStart AND :periodEnd) AND " +
            "(:open IS NULL OR invoice.payedAt is null) AND " +
            "(:closed IS NULL OR invoice.payedAt is not null) AND " +
            "(:overdue IS NULL OR (invoice.payedAt is null and dueDate < :now))  AND " +
            "(:selectedNumber IS NULL OR invoice.number = :selectedNumber )  "
    )
    Page<InvoiceModel> paginateInvoices(
        @Param("selectedNumber") String selectedNumber,
        @Param("selectedCustomer") String selectedCustomer,
        @Param("selectedCategory") String selectedCategory,
        @Param("selectedAddress") String selectedAddress,
        @Param("periodStart") LocalDateTime periodStart,
        @Param("periodEnd") LocalDateTime periodEnd,
        @Param("open") Boolean open,
        @Param("closed") Boolean closed,
        @Param("overdue") Boolean overdue,
        @Param("now") LocalDateTime now,
        Pageable pageable
    );

    @Query(
            " SELECT invoice " +
                    " FROM InvoiceModel invoice " +
                    " LEFT JOIN FETCH invoice.waterMeter waterMeter " +
                    " LEFT JOIN FETCH invoice.link link " +
                    " LEFT JOIN FETCH link.customer customer " +
                    " LEFT JOIN FETCH customer.partner partner " +
                    " LEFT JOIN FETCH link.address address " +
                    " LEFT JOIN FETCH link.category category " +
                    " LEFT JOIN FETCH category.price price " +
                    " WHERE " +
                    "(:selectedCustomer IS NULL OR customer.number = :selectedCustomer ) AND " +
                    "(:selectedCategory IS NULL OR category.number = :selectedCategory ) AND " +
                    "(:selectedAddress IS NULL OR address.number = :selectedAddress ) AND" +
                    "(:periodStart IS NULL OR invoice.period BETWEEN :periodStart AND :periodEnd) AND " +
                    "(:open IS NULL OR invoice.payedAt is null) AND " +
                    "(:closed IS NULL OR invoice.payedAt is not null) AND " +
                    "(:overdue IS NULL OR (invoice.payedAt is null and dueDate < :now))  AND " +
                    "(:selectedNumber IS NULL OR invoice.number = :selectedNumber )  "
    )
    List<InvoiceModel> findInvoices(
            @Param("selectedNumber") String selectedNumber,
            @Param("selectedCustomer") String selectedCustomer,
            @Param("selectedCategory") String selectedCategory,
            @Param("selectedAddress") String selectedAddress,
            @Param("periodStart") LocalDateTime periodStart,
            @Param("periodEnd") LocalDateTime periodEnd,
            @Param("open") Boolean open,
            @Param("closed") Boolean closed,
            @Param("overdue") Boolean overdue,
            @Param("now") LocalDateTime now
    );
}

