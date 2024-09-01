package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "entrada")

public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    private Date data;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "idCedente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Socio idCedente;
    @JoinColumn(name = "idMotivoEntrada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Motivoentrada idMotivoEntrada;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public Entrada() {
    }

    public Entrada(Integer id) {
        this.id = id;
    }

    public Entrada(Integer id, Date data, BigDecimal valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Socio getIdCedente() {
        return idCedente;
    }

    public void setIdCedente(Socio idCedente) {
        this.idCedente = idCedente;
    }

    public Motivoentrada getIdMotivoEntrada() {
        return idMotivoEntrada;
    }

    public void setIdMotivoEntrada(Motivoentrada idMotivoEntrada) {
        this.idMotivoEntrada = idMotivoEntrada;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Entrada other)) {
            return false;
        }
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entidades.Entrada[ id=" + id + " ]";
    }
    
}
