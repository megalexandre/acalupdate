package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
@Entity
@Table(name = "socios_view")
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
