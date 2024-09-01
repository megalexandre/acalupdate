package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEndereco")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEndereco")
    private List<Enderecopessoa> enderecopessoaList;
    
    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Endereco(Integer id, String tipo, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Endereco[ id=" + id + " ]";
    }

    public List<Enderecopessoa> getEnderecopessoaList() {
        return enderecopessoaList;
    }

    public void setEnderecopessoaList(List<Enderecopessoa> enderecopessoaList) {
        this.enderecopessoaList = enderecopessoaList;
    }
    
}
