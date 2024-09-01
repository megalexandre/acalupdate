package br.org.acal.resouces.model;

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

    @Column(name = "valor")
    private BigDecimal value;

}
