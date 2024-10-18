package br.org.acal.resouces.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "hidrometro")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaterMeterModel implements Serializable {

    @Id
    @Column(name = "idhidrometro")
    @GeneratedValue(strategy = IDENTITY)
    private String number;

    @Column(name = "consumo_inicial")
    private Double consumptionStart;

    @Column(name = "consumo_final")
    private Double consumptionEnd;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConta", referencedColumnName = "id")
    private InvoiceModel invoice;

}
