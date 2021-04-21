package br.com.zupacademy.jessica.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank
    @Email(message = "Email é obrigatório e preicisa ser válido!")
    private String email;

    @NotBlank(message = "Descrição é obrigatória!")
    @Size(max = 400)
    private String descricao;

    private final LocalDateTime instanteregistro = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteregistro() {
        return instanteregistro;
    }

    public long getId() {
        return id;
    }
}
