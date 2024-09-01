package br.org.acal.resouces.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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