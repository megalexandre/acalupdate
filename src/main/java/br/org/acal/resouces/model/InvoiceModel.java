package br.org.acal.resouces.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "conta")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "idEnderecoPessoa", referencedColumnName = "id")
    private LinkModel link;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.ALL)
    private WaterMeterModel waterMeter;

    @Column(name = "dataPag")
    private LocalDateTime payedAt;

    @Basic(optional = false)
    @Column(name = "dataVence")
    private LocalDateTime dueDate;

    @Column(name = "dataGerada")
    private LocalDateTime createdAt;

    @Column(name = "dataReferente", nullable = false)
    private LocalDateTime period;

    @Column(name = "ValorTaxa")
    private BigDecimal partnerValue;

    @Column(name = "ValorOutros")
    private BigDecimal otherValues;

}
