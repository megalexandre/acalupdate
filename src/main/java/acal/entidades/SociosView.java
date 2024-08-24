/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acal.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACAL
 */
@Entity
@Table(name = "socios_view")
@XmlRootElement

public class SociosView implements Serializable {
    @Column(name = "SocioExclusivo")
    private Boolean socioExclusivo;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "nome")
    private String nome;

    public SociosView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getSocioExclusivo() {
        return socioExclusivo;
    }

    public void setSocioExclusivo(Boolean socioExclusivo) {
        this.socioExclusivo = socioExclusivo;
    }
    
}
