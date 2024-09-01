package br.org.acal.resouces.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
