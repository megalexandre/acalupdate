package br.org.acal.resources.model

import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "tipo_parametro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class WaterParamModel : Serializable {
    @Id
    @Column(name = "ide_tipo_parametro")
    private var number: String? = null

    @Basic(optional = false)
    @Column(name = "nom_parametro")
    private var nome: String? = null
}