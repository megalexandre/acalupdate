package acal.resource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
