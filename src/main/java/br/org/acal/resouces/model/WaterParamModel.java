package br.org.acal.resouces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tipo_parametro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterParamModel implements Serializable {

    @Id
    @Column(name = "ide_tipo_parametro")
    private String number;

    @Basic(optional = false)
    @Column(name = "nom_parametro")
    private String nome;

}