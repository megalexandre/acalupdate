package br.org.acal.resouces.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
