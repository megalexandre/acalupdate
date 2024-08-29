package br.org.acal.resouces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "categoriasocio")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryModel implements Serializable {

    @Id
    @Column(name = "id")
    private String number;

    @Basic(optional = false)
    @Column(name = "nome")
    private String name;

    @JoinColumn(name = "taxasId", referencedColumnName = "id")
    @ManyToOne
    private PriceModel price;

}
