package br.org.acal.resouces.entidades;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "conta")

public class Conta implements Serializable {
    @Basic(optional = false)
    @Column(name = "SocioExclusivo")
    private boolean socioExclusivo;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Basic(optional = false)
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idconta")
    private Hidrometro hidrometro;
    @Column(name = "dataGerada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGerada;
    @JoinColumn(name = "idEnderecoPessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Enderecopessoa idEnderecoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaid", fetch= FetchType.EAGER)
    private List<Taxasconta> taxascontaList;
     // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorTaxa")
    private BigDecimal valorTaxa;
    @Column(name = "ValorOutros")
    private BigDecimal valorOutros;
   
    public List<Taxasconta> getTaxascontaList() {
        return taxascontaList;
    }

    public void setTaxascontaList(List<Taxasconta> taxascontaList) {
        this.taxascontaList = taxascontaList;
    }
    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, Date dataVence) {
        this.id = id;
        this.dataVence = dataVence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

   

    public Hidrometro getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(Hidrometro hidrometro) {
        this.hidrometro = hidrometro;
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
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Conta[ id=" + id + " ]";
    }

    public Date getDataGerada() {
        return dataGerada;
    }

    public void setDataGerada(Date dataGerada) {
        this.dataGerada = dataGerada;
    }

    public Enderecopessoa getIdEnderecoPessoa() {
        return idEnderecoPessoa;
    }

    public void setIdEnderecoPessoa(Enderecopessoa idEnderecoPessoa) {
        this.idEnderecoPessoa = idEnderecoPessoa;
    }

    public BigDecimal getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(BigDecimal valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public BigDecimal getValorOutros() {
        return valorOutros;
    }

    public void setValorOutros(BigDecimal valorOutros) {
        this.valorOutros = valorOutros;
    }

    public boolean getSocioExclusivo() {
        return socioExclusivo;
    }

    public void setSocioExclusivo(boolean socioExclusivo) {
        this.socioExclusivo = socioExclusivo;
    }
    
}
