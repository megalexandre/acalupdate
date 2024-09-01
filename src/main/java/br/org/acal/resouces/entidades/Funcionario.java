/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "funcionario")

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "dataContratacao")
    private Date dataContratacao;
    @Basic(optional = false)
    @Column(name = "matricula")
    private int matricula;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "salario")
    private BigDecimal salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario")
    private List<Saida> saidaList;
    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Pessoa idPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private List<Entrada> entradaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private List<Cheque> chequeList;

    public Funcionario() {
    }

    public Funcionario(Integer id) {
        this.id = id;
    }

    public Funcionario(Integer id, String cargo, Date dataContratacao, int matricula, BigDecimal salario) {
        this.id = id;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        this.matricula = matricula;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<Saida> getSaidaList() {
        return saidaList;
    }

    public void setSaidaList(List<Saida> saidaList) {
        this.saidaList = saidaList;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    public List<Cheque> getChequeList() {
        return chequeList;
    }

    public void setChequeList(List<Cheque> chequeList) {
        this.chequeList = chequeList;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Funcionario[ id=" + id + " ]";
    }
    
}
