package acal.resource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CustomerModel customer;

    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AddressModel address;

    @JoinColumn(name = "idCategoriaSocio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoryModel category;

    @Column(name = "Numero")
    private String partnerNumber;
}
