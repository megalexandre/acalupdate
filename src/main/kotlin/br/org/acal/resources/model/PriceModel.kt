package br.org.acal.resources.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.math.BigDecimal
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "taxa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class PriceModel : Serializable {
    @Id
    @Column(name = "id")
    private var number: String? = null

    @Column(name = "nome")
    private var name: String? = null

    @Column(name = "valor")
    private var value: BigDecimal? = null
}
