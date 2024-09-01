package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "rc_conta")
@NamedQueries({
    @NamedQuery(name = "RcConta.findAll", query = "SELECT r FROM RcConta r"),
    @NamedQuery(name = "RcConta.findByNumeroconta", query = "SELECT r FROM RcConta r WHERE r.numeroconta = :numeroconta"),
    @NamedQuery(name = "RcConta.findByData", query = "SELECT r FROM RcConta r WHERE r.data = :data"),
    @NamedQuery(name = "RcConta.findByPagamento", query = "SELECT r FROM RcConta r WHERE r.pagamento = :pagamento"),
    @NamedQuery(name = "RcConta.findByVencimento", query = "SELECT r FROM RcConta r WHERE r.vencimento = :vencimento"),
    @NamedQuery(name = "RcConta.findBySocio", query = "SELECT r FROM RcConta r WHERE r.socio = :socio"),
    @NamedQuery(name = "RcConta.findByEndereco", query = "SELECT r FROM RcConta r WHERE r.endereco = :endereco"),
    @NamedQuery(name = "RcConta.findByNumero", query = "SELECT r FROM RcConta r WHERE r.numero = :numero"),
    @NamedQuery(name = "RcConta.findByNumeroSocio", query = "SELECT r FROM RcConta r WHERE r.numeroSocio = :numeroSocio"),
    @NamedQuery(name = "RcConta.findByCategoriaSocio", query = "SELECT r FROM RcConta r WHERE r.categoriaSocio = :categoriaSocio"),
    @NamedQuery(name = "RcConta.findByTaxaSocio", query = "SELECT r FROM RcConta r WHERE r.taxaSocio = :taxaSocio"),
    @NamedQuery(name = "RcConta.findByConsumo", query = "SELECT r FROM RcConta r WHERE r.consumo = :consumo"),
    @NamedQuery(name = "RcConta.findByExcessoLTd", query = "SELECT r FROM RcConta r WHERE r.excessoLTd = :excessoLTd"),
    @NamedQuery(name = "RcConta.findByExcessoValor", query = "SELECT r FROM RcConta r WHERE r.excessoValor = :excessoValor"),
    @NamedQuery(name = "RcConta.findByTaxas", query = "SELECT r FROM RcConta r WHERE r.taxas = :taxas"),
    @NamedQuery(name = "RcConta.findByTotalconta", query = "SELECT r FROM RcConta r WHERE r.totalconta = :totalconta")})
public class RcConta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "taxas")
    private int taxas;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numeroconta")
    private int numeroconta;
    @Column(name = "data")
    private Date data;
    @Column(name = "pagamento")
    private Date pagamento;
    @Basic(optional = false)
    @Column(name = "vencimento")
    private Date vencimento;
    @Column(name = "socio")
    private String socio;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "numeroSocio")
    private int numeroSocio;
    @Basic(optional = false)
    @Column(name = "categoriaSocio")
    private String categoriaSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "taxaSocio")
    private BigDecimal taxaSocio;
    @Column(name = "consumo")
    private Double consumo;
    @Column(name = "excessoLTd")
    private Double excessoLTd;
    @Column(name = "excessoValor")
    private Double excessoValor;
    @Column(name = "totalconta")
    private Double totalconta;

    public RcConta() {
    }

    public int getNumeroconta() {
        return numeroconta;
    }

    public void setNumeroconta(int numeroconta) {
        this.numeroconta = numeroconta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getPagamento() {
        return pagamento;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getCategoriaSocio() {
        return categoriaSocio;
    }

    public void setCategoriaSocio(String categoriaSocio) {
        this.categoriaSocio = categoriaSocio;
    }

    public BigDecimal getTaxaSocio() {
        return taxaSocio;
    }

    public void setTaxaSocio(BigDecimal taxaSocio) {
        this.taxaSocio = taxaSocio;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getExcessoLTd() {
        return excessoLTd;
    }

    public void setExcessoLTd(Double excessoLTd) {
        this.excessoLTd = excessoLTd;
    }

    public Double getExcessoValor() {
        return excessoValor;
    }

    public void setExcessoValor(Double excessoValor) {
        this.excessoValor = excessoValor;
    }

    public Double getTotalconta() {
        return totalconta;
    }

    public void setTotalconta(Double totalconta) {
        this.totalconta = totalconta;
    }

    public int getTaxas() {
        return taxas;
    }

    public void setTaxas(int taxas) {
        this.taxas = taxas;
    }
    
}
