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
@Table(name = "socio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class PartnerModel(

    @Id
    @Column(name = "id")
    val number: String,

    @Column(name = "SocioExclusivo")
    val memberOnly: Boolean,

    @Column(name = "numeroSocio")
    val partnerNumber: Number,

    @OneToOne
    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    val customer: CustomerModel,

) : Serializable
