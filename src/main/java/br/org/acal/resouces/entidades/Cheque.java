/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "cheque")

public class Cheque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataPagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;
    @Basic(optional = false)
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "idMotivoDespesa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Motivodespesa idMotivoDespesa;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public Cheque() {
    }

    public Cheque(Integer id) {
        this.id = id;
    }

    public Cheque(Integer id, Date dataVencimento, int numero, BigDecimal valor) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.numero = numero;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Motivodespesa getIdMotivoDespesa() {
        return idMotivoDespesa;
    }

    public void setIdMotivoDespesa(Motivodespesa idMotivoDespesa) {
        this.idMotivoDespesa = idMotivoDespesa;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cheque)) {
            return false;
        }
        Cheque other = (Cheque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cheque[ id=" + id + " ]";
    }
    
}
