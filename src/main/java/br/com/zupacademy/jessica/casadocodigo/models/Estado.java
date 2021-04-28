package br.com.zupacademy.jessica.casadocodigo.models;

import br.com.zupacademy.jessica.casadocodigo.requests.validators.EstadoUnicoPorPais;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    private long id;

    @NotBlank(message = "Nome do estado é obrigatorio")
    private String nome;

    @ManyToOne
    private Pais pais;

    public String getNome() { return nome; }

    public Pais getPais() { return pais; }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado(){ }
}
