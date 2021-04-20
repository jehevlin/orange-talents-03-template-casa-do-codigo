package br.com.zupacademy.jessica.casadocodigo.novoautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Autor {

    @NotBlank (message = "Nome é obrigatório!")
    private String nome;

    @NotBlank
    @Email (message = "Email é obrigatório e preicisa ser válido!")
    private String email;

    @NotBlank (message = "Descrição é obrigatória!")
    @Size(max = 400)
    private String descricao;

    private final LocalDateTime instanteregistro = LocalDateTime.now();


    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getDescricao() { return descricao; }

    public LocalDateTime getInstanteregistro() { return instanteregistro; }
}
