package br.org.acal.resources.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.io.Serializable
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "hidrometro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class WaterMeterModel : Serializable {
    @Id
    @Column(name = "idhidrometro")
    private var number: String? = null

    @Column(name = "consumo_inicial")
    private var consumptionStart: Double? = null

    @Column(name = "consumo_final")
    private var consumptionEnd: Double? = null

    @OneToOne
    @JoinColumn(name = "idConta", referencedColumnName = "id")
    private val invoice: InvoiceModel? = null
}
