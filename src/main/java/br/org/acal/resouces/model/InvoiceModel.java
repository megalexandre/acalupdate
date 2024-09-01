package br.org.acal.resouces.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "conta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceModel {

    @Id
    @Column(name = "id")
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEnderecoPessoa", referencedColumnName = "id")
    private LinkModel link;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "invoice", cascade = CascadeType.ALL)
    private WaterMeterModel waterMeter;

    @Column(name = "dataPag")
    private LocalDateTime payedAt;

    @Basic(optional = false)
    @Column(name = "dataVence")
    private LocalDateTime dueDate;

    @Column(name = "dataGerada")
    private LocalDateTime createdAt;

    @Column(name = "dataReferente")
    private LocalDateTime period;

    @Column(name = "ValorTaxa")
    private BigDecimal partnerValue;

    @Column(name = "ValorOutros")
    private BigDecimal otherValues;

}
