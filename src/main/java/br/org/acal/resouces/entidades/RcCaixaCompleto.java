/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author Head
 */
@Entity
@Table(name = "rc_caixa_completo")

public class RcCaixaCompleto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numeroconta")
    @Id
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
    @Column(name = "taxas")
    private BigDecimal taxas;
    @Column(name = "totalconta")
    private Double totalconta;

    public RcCaixaCompleto() {
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
