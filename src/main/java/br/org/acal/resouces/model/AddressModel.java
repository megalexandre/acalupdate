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
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressModel implements Serializable {

    @Id
    @Column(name = "id")
    private String number;

    @Basic(optional = false)
    @Column(name = "tipo")
    private String type;

    @Basic(optional = false)
    @Column(name = "nome")
    private String name;

}