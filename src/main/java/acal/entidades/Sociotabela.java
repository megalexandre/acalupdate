package acal.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sociotabela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sociotabela.findAll", query = "SELECT s FROM Sociotabela s"),
    @NamedQuery(name = "Sociotabela.findById", query = "SELECT s FROM Sociotabela s WHERE s.id = :id"),
    @NamedQuery(name = "Sociotabela.findByIdSocio", query = "SELECT s FROM Sociotabela s WHERE s.idSocio = :idSocio"),
    @NamedQuery(name = "Sociotabela.findByNomeCompleto", query = "SELECT s FROM Sociotabela s WHERE s.nomeCompleto = :nomeCompleto"),
    @NamedQuery(name = "Sociotabela.findByCpf", query = "SELECT s FROM Sociotabela s WHERE s.cpf = :cpf"),
    @NamedQuery(name = "Sociotabela.findByNome", query = "SELECT s FROM Sociotabela s WHERE s.nome = :nome"),
    @NamedQuery(name = "Sociotabela.findByEndereco", query = "SELECT s FROM Sociotabela s WHERE s.endereco = :endereco"),
    @NamedQuery(name = "Sociotabela.findByNumero", query = "SELECT s FROM Sociotabela s WHERE s.numero = :numero")})
public class Sociotabela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "idSocio")
    private int idSocio;
    @Column(name = "nomeCompleto")
    private String nomeCompleto;
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;

    public Sociotabela() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
}
