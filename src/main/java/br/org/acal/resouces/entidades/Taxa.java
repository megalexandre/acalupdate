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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "taxa")
public class Taxa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxaid")
    private List<Taxasconta> taxascontaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxasId")
    private List<Categoriasocio> categoriasocioList;

    public Taxa() {
    }

    public Taxa(Integer id) {
        this.id = id;
    }

    public Taxa(Integer id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Taxasconta> getTaxascontaList() {
        return taxascontaList;
    }

    public void setTaxascontaList(List<Taxasconta> taxascontaList) {
        this.taxascontaList = taxascontaList;
    }

    public List<Categoriasocio> getCategoriasocioList() {
        return categoriasocioList;
    }

    public void setCategoriasocioList(List<Categoriasocio> categoriasocioList) {
        this.categoriasocioList = categoriasocioList;
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
        if (!(object instanceof Taxa)) {
            return false;
        }
        Taxa other = (Taxa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Taxa[ id=" + id + " ]";
    }
    
}
