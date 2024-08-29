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
import javax.persistence.Lob;
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
@Table(name = "contaslog")

public class Contaslog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idOriginal")
    private Integer idOriginal;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "taxaSocio")
    private Integer taxaSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaRelogio")
    private BigDecimal taxaRelogio;
    @Column(name = "idNumeroSocio")
    private Integer idNumeroSocio;
    @Column(name = "horaRegristro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaRegristro;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "usuarioAlteracao")
    private String usuarioAlteracao;

    public Contaslog() {
    }

    public Contaslog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOriginal() {
        return idOriginal;
    }

    public void setIdOriginal(Integer idOriginal) {
        this.idOriginal = idOriginal;
    }

    public Date getDataPag() {
        return dataPag;
    }

    public void setDataPag(Date dataPag) {
        this.dataPag = dataPag;
    }

    public Date getDataVence() {
        return dataVence;
    }

    public void setDataVence(Date dataVence) {
        this.dataVence = dataVence;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getTaxaSocio() {
        return taxaSocio;
    }

    public void setTaxaSocio(Integer taxaSocio) {
        this.taxaSocio = taxaSocio;
    }

    public BigDecimal getTaxaRelogio() {
        return taxaRelogio;
    }

    public void setTaxaRelogio(BigDecimal taxaRelogio) {
        this.taxaRelogio = taxaRelogio;
    }

    public Integer getIdNumeroSocio() {
        return idNumeroSocio;
    }

    public void setIdNumeroSocio(Integer idNumeroSocio) {
        this.idNumeroSocio = idNumeroSocio;
    }

    public Date getHoraRegristro() {
        return horaRegristro;
    }

    public void setHoraRegristro(Date horaRegristro) {
        this.horaRegristro = horaRegristro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
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
        if (!(object instanceof Contaslog)) {
            return false;
        }
        Contaslog other = (Contaslog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Contaslog[ id=" + id + " ]";
    }
    
}
