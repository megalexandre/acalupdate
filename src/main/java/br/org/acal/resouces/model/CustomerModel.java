package br.org.acal.resouces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pessoa")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerModel implements Serializable {

    @Id
    @Column(name = "id")
    private String number;

    @Basic(optional = false)
    @Column(name = "nome")
    private String name;

    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String lastName;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private PartnerModel partner;
}
