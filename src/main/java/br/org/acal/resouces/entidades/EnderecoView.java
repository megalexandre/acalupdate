package br.org.acal.resouces.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "endereco_view")
public class EnderecoView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;

}
