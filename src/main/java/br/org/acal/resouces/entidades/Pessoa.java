package br.org.acal.resouces.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "pessoa")

@Data
@NoArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "numeroEndereco")
    private String numeroEndereco;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "nomeMae")
    private String nomeMae;
    @Column(name = "nomePai")
    private String nomePai;
    @Column(name = "numeroMatricula")
    private Integer numeroMatricula;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "rgExpedidor")
    private String rgExpedidor;
    @Column(name = "rgNumero")
    private String rgNumero;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "uf")
    private String uf;
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Endereco idEndereco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Funcionario funcionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Socio socio;
     @Column(name = "dataNasc")
    private Date dataNasc;
    @Column(name = "rgEmissao")
    private Date rgEmissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa", fetch = FetchType.EAGER)
    private List<Enderecopessoa> enderecopessoaList;

    @Column(name = "cnpj")
    private String cnpj;

}
