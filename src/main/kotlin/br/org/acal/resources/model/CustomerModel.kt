package br.org.acal.resources.model

import jakarta.persistence.Basic
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.io.Serializable
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class CustomerModel(
    
    @Id
    @Column(name = "id")
    val number: String,

    @Basic(optional = false)
    @Column(name = "nome")
    val name: String,

    @Basic(optional = false)
    @Column(name = "sobrenome")
    val lastName: String? = null,

    @OneToOne(mappedBy = "customer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val partner: PartnerModel,

    @Column(name = "cnpj")
    val cnpj: String? = null,

    @Column(name = "cpf")
    val cpf: String? = null,

)
