package br.org.acal.resources.model

import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.time.LocalDate
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "parametro_coleta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class WaterQualityModel : Serializable {
    @Id
    @Column(name = "ide_parametro_coleta")
    private var number: String? = null

    @Basic(optional = false)
    @Column(name = "ide_tipo_parametro")
    private var param: String? = null

    @Basic(optional = false)
    @Column(name = "exigido")
    private var required: String? = null

    @Basic(optional = false)
    @Column(name = "analisado")
    private var analyzed: String? = null

    @Basic(optional = false)
    @Column(name = "conformidade")
    private var accordance: String? = null

    @Basic(optional = false)
    @Column(name = "data")
    private var date: LocalDate? = null
}