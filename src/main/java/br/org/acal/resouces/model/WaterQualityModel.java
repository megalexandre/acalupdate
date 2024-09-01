package br.org.acal.resouces.model;

import jakarta.persistence.Basic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "parametro_coleta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterQualityModel implements Serializable {

    @Id
    @Column(name = "ide_parametro_coleta")
    private String number;

    @Basic(optional = false)
    @Column(name = "ide_tipo_parametro")
    private String param;

    @Basic(optional = false)
    @Column(name = "exigido")
    private String required;

    @Basic(optional = false)
    @Column(name = "analisado")
    private String analyzed;

    @Basic(optional = false)
    @Column(name = "conformidade")
    private String accordance;

    @Basic(optional = false)
    @Column(name = "data")
    private LocalDate date;

}