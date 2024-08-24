/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acal.entidades;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "categoriasocio")
public class Categoriasocio implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaSocio")
    private List<Enderecopessoa> enderecopessoaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "taxasId", referencedColumnName = "id")
    @ManyToOne
    private Taxa taxasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaSocio")
    private List<Socio> socioList;

    public Categoriasocio() {
    }

    public Categoriasocio(Integer id) {
        this.id = id;
    }

    public Categoriasocio(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Taxa getTaxasId() {
        return taxasId;
    }

    public void setTaxasId(Taxa taxasId) {
        this.taxasId = taxasId;
    }

    public List<Socio> getSocioList() {
        return socioList;
    }

    public void setSocioList(List<Socio> socioList) {
        this.socioList = socioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Categoriasocio)) {
            return false;
        }
        Categoriasocio other = (Categoriasocio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CategoriaSocio[ id=" + id + " ]";
    }

    public List<Enderecopessoa> getEnderecopessoaList() {
        return enderecopessoaList;
    }

    public void setEnderecopessoaList(List<Enderecopessoa> enderecopessoaList) {
        this.enderecopessoaList = enderecopessoaList;
    }
    
}
