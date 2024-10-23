package br.org.acal.resouces.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pessoa")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private String number;

    @Basic(optional = false)
    @Column(name = "nome")
    private String name;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "partner_number")
    private String partnerNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private PartnerModel partner;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String phoneNumber;

    @Column(name = "status")
    private Boolean active;

}
