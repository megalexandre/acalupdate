/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "taxasconta")
@XmlRootElement

public class Taxasconta implements Serializable {
    @Basic(optional = false)
    @Column(name = "BitTeste")
    private boolean bitTeste;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtaxasConta")
    private Integer idtaxasConta;
    @JoinColumn(name = "taxaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Taxa taxaid;
    @JoinColumn(name = "contaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conta contaid;

    public Taxasconta() {
    }

    public Taxasconta(Integer idtaxasConta) {
        this.idtaxasConta = idtaxasConta;
    }

    public Integer getIdtaxasConta() {
        return idtaxasConta;
    }

    public void setIdtaxasConta(Integer idtaxasConta) {
        this.idtaxasConta = idtaxasConta;
    }

    public Taxa getTaxaid() {
        return taxaid;
    }

    public void setTaxaid(Taxa taxaid) {
        this.taxaid = taxaid;
    }

    public Conta getContaid() {
        return contaid;
    }

    public void setContaid(Conta contaid) {
        this.contaid = contaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtaxasConta != null ? idtaxasConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxasconta)) {
            return false;
        }
        Taxasconta other = (Taxasconta) object;
        if ((this.idtaxasConta == null && other.idtaxasConta != null) || (this.idtaxasConta != null && !this.idtaxasConta.equals(other.idtaxasConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Taxasconta[ idtaxasConta=" + idtaxasConta + " ]";
    }

    public boolean getBitTeste() {
        return bitTeste;
    }

    public void setBitTeste(boolean bitTeste) {
        this.bitTeste = bitTeste;
    }
    
}
