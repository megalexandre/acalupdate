package acal.resource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

    @Basic(optional = false)
    @Column(name = "numeroSocio")
    private int partnerNumber;

    @OneToOne
    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    private CustomerModel customer;

}
