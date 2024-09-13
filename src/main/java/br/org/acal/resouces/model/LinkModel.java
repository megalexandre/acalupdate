package br.org.acal.resouces.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "enderecopessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkModel implements Serializable {

    @Id
    @Column(name = "id")
    private String number;

    @JoinColumn( name = "idPessoa", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CustomerModel customer;

    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private AddressModel address;

    @JoinColumn(name = "idCategoriaSocio", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CategoryModel category;

    @Column(name = "Numero")
    private String linkNumber;

    @Column(name = "inativo")
    private Boolean inactive;
}
