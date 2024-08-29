package br.org.acal.resouces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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