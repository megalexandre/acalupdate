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
import java.math.BigDecimal;

@Entity
@Table(name = "taxa")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceModel implements Serializable {

    @Id
    @Column(name = "id")
    private String number;

    @Column(name = "nome")
    private String name;

    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal value;

}
