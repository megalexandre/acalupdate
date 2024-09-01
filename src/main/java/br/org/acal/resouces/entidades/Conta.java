package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "conta")
@Data
@NoArgsConstructor
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dataPag")
    private Date dataPag;

    @Basic(optional = false)
    @Column(name = "dataVence")
    private Date dataVence;

    @Lob
    @Column(name = "observacoes")
    private String observacoes;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "idconta")
    @Transient
    private Hidrometro hidrometro;

    @Column(name = "dataGerada")
    private Date dataGerada;

    @JoinColumn(name = "idEnderecoPessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Enderecopessoa idEnderecoPessoa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaid", fetch= FetchType.EAGER)
    private List<Taxasconta> taxascontaList;

    @Column(name = "ValorTaxa")
    private BigDecimal valorTaxa;

    @Column(name = "ValorOutros")
    private BigDecimal valorOutros;

    @Basic(optional = false)
    @Column(name = "SocioExclusivo")
    private boolean socioExclusivo;

}
