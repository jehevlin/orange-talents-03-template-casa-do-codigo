package br.com.zupacademy.jessica.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Categoria() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
