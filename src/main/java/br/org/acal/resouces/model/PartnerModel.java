package br.org.acal.resouces.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "socio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerModel implements Serializable {

    @Id
    @Column(name = "id")
    private String number;

    @Column(name = "SocioExclusivo")
    private Boolean memberOnly;

    @Column(name = "numeroSocio")
    private int partnerNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    private CustomerModel customer;

}
