package acal.resource.model;

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