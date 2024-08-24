/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acal.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Head
 */
@Entity
@Table(name = "contas_view")

public class ContasView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numeroconta")
    @Id
    private int numeroconta;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagamento;
    @Basic(optional = false)
    @Column(name = "vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimento;
    @Column(name = "MesReferente")
    private String mesReferente;
    @Column(name = "AnoReferente")
    private Integer anoReferente;
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
    @Column(name = "taxas")
    private BigDecimal taxas;
    @Column(name = "totalconta")
    private Double totalconta;

    public ContasView() {
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

    public String getMesReferente() {
        return mesReferente;
    }

    public void setMesReferente(String mesReferente) {
        this.mesReferente = mesReferente;
    }

    public Integer getAnoReferente() {
        return anoReferente;
    }

    public void setAnoReferente(Integer anoReferente) {
        this.anoReferente = anoReferente;
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

    public BigDecimal getTaxas() {
        return taxas;
    }

    public void setTaxas(BigDecimal taxas) {
        this.taxas = taxas;
    }

    public Double getTotalconta() {
        return totalconta;
    }

    public void setTotalconta(Double totalconta) {
        this.totalconta = totalconta;
    }
    
}
