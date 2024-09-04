package br.org.acal.resources.model

import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.io.Serializable
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "categoriasocio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class CategoryModel : Serializable {
    @Id
    @Column(name = "id")
    private var number: String? = null

    @Basic(optional = false)
    @Column(name = "nome")
    private var name: String? = null

    @JoinColumn(name = "taxasId", referencedColumnName = "id")
    @ManyToOne
    private val price: PriceModel? = null
}
