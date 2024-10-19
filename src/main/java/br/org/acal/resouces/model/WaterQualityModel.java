package br.org.acal.resouces.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "parametro_coleta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterQualityModel implements Serializable {

    @Id
    @Column(name = "ide_parametro_coleta")
    @GeneratedValue(strategy = IDENTITY)
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