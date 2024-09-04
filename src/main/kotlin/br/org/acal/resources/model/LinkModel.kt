package br.org.acal.resources.model

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
@Table(name = "enderecopessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class LinkModel : Serializable {
    @Id
    @Column(name = "id")
    private var number: String? = null

    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private val customer: CustomerModel? = null

    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private val address: AddressModel? = null

    @JoinColumn(name = "idCategoriaSocio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private val category: CategoryModel? = null

    @Column(name = "Numero")
    private var partnerNumber: String? = null
}
