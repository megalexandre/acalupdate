package acal.resource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "hidrometro")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterMeterModel implements Serializable {

    @Id
    @Column(name = "idhidrometro")
    private String number;

    @Column(name = "consumo_inicial")
    private Double consumptionStart;

    @Column(name = "consumo_final")
    private Double consumptionEnd;

    @OneToOne
    @JoinColumn(name = "idConta", referencedColumnName = "id")
    private InvoiceModel invoice;
}
