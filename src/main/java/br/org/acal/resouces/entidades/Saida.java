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
@Table(name = "saida")

public class Saida implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "favorecido")
    private String favorecido;
    @JoinColumn(name = "idmotivosaida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Motivodespesa idmotivosaida;
    @JoinColumn(name = "idfuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario idfuncionario;

    public Saida() {
    }

    public Saida(Integer id) {
        this.id = id;
    }

    public Saida(Integer id, Date data, BigDecimal valor, String favorecido) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.favorecido = favorecido;
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

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public Motivodespesa getIdmotivosaida() {
        return idmotivosaida;
    }

    public void setIdmotivosaida(Motivodespesa idmotivosaida) {
        this.idmotivosaida = idmotivosaida;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Saida[ id=" + id + " ]";
    }
    
}
