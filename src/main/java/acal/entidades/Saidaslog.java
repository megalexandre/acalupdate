/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acal.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "saidaslog")
@XmlRootElement

public class Saidaslog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idoriginal")
    private Integer idoriginal;
    @Column(name = "dataoriginal")
    @Temporal(TemporalType.DATE)
    private Date dataoriginal;
    @Column(name = "dataalteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataalteracao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "favorecido")
    private String favorecido;
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Column(name = "idFuncionarioAltercao")
    private Integer idFuncionarioAltercao;
    @Column(name = "usuarioAlteracao")
    private String usuarioAlteracao;
    @Column(name = "idmotivosaida")
    private Integer idmotivosaida;
    @Column(name = "tipo")
    private String tipo;
    @Lob
    @Column(name = "observacao")
    private String observacao;

    public Saidaslog() {
    }

    public Saidaslog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdoriginal() {
        return idoriginal;
    }

    public void setIdoriginal(Integer idoriginal) {
        this.idoriginal = idoriginal;
    }

    public Date getDataoriginal() {
        return dataoriginal;
    }

    public void setDataoriginal(Date dataoriginal) {
        this.dataoriginal = dataoriginal;
    }

    public Date getDataalteracao() {
        return dataalteracao;
    }

    public void setDataalteracao(Date dataalteracao) {
        this.dataalteracao = dataalteracao;
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

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdFuncionarioAltercao() {
        return idFuncionarioAltercao;
    }

    public void setIdFuncionarioAltercao(Integer idFuncionarioAltercao) {
        this.idFuncionarioAltercao = idFuncionarioAltercao;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Integer getIdmotivosaida() {
        return idmotivosaida;
    }

    public void setIdmotivosaida(Integer idmotivosaida) {
        this.idmotivosaida = idmotivosaida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        if (!(object instanceof Saidaslog)) {
            return false;
        }
        Saidaslog other = (Saidaslog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Saidaslog[ id=" + id + " ]";
    }
    
}
