/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acal.entidades;

import java.io.Serializable;
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
 * @author megalexandre
 */
@Entity
@Table(name = "messagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messagem.findAll", query = "SELECT m FROM Messagem m"),
    @NamedQuery(name = "Messagem.findById", query = "SELECT m FROM Messagem m WHERE m.id = :id"),
    @NamedQuery(name = "Messagem.findByTitulo", query = "SELECT m FROM Messagem m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "Messagem.findByData", query = "SELECT m FROM Messagem m WHERE m.data = :data"),
    @NamedQuery(name = "Messagem.findByResponsavel", query = "SELECT m FROM Messagem m WHERE m.responsavel = :responsavel")})
public class Messagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "corpo")
    private String corpo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "responsavel")
    private String responsavel;

    public Messagem() {
    }

    public Messagem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
        if (!(object instanceof Messagem)) {
            return false;
        }
        Messagem other = (Messagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Messagem[ id=" + id + " ]";
    }
    
}
