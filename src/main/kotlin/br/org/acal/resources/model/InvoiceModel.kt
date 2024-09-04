package br.org.acal.resources.model

import jakarta.persistence.Basic
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "conta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class InvoiceModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var number: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEnderecoPessoa", referencedColumnName = "id")
    private val link: LinkModel? = null

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "invoice", cascade = [CascadeType.ALL])
    private val waterMeter: WaterMeterModel? = null

    @Column(name = "dataPag")
    private var payedAt: LocalDateTime? = null

    @Basic(optional = false)
    @Column(name = "dataVence")
    private var dueDate: LocalDateTime? = null

    @Column(name = "dataGerada")
    private var createdAt: LocalDateTime? = null

    @Column(name = "dataReferente")
    private var period: LocalDateTime? = null

    @Column(name = "ValorTaxa")
    private var partnerValue: BigDecimal? = null

    @Column(name = "ValorOutros")
    private var otherValues: BigDecimal? = null
}
