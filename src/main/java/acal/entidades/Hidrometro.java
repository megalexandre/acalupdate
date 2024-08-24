/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acal.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "hidrometro")
@XmlRootElement

public class Hidrometro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhidrometro")
    private Integer idhidrometro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Consumo")
    private Double consumo;
    @JoinColumn(name = "idconta", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Conta idconta;

    public Hidrometro() {
    }

    public Hidrometro(Integer idhidrometro) {
        this.idhidrometro = idhidrometro;
    }

    public Integer getIdhidrometro() {
        return idhidrometro;
    }

    public void setIdhidrometro(Integer idhidrometro) {
        this.idhidrometro = idhidrometro;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Conta getIdconta() {
        return idconta;
    }

    public void setIdconta(Conta idconta) {
        this.idconta = idconta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhidrometro != null ? idhidrometro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hidrometro)) {
            return false;
        }
        Hidrometro other = (Hidrometro) object;
        if ((this.idhidrometro == null && other.idhidrometro != null) || (this.idhidrometro != null && !this.idhidrometro.equals(other.idhidrometro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Hidrometro[ idhidrometro=" + idhidrometro + " ]";
    }
    
}
