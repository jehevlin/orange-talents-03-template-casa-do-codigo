package br.com.zupacademy.jessica.casadocodigo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class Autor {

    @NotBlank (message = "Nome é obrigatório!")
    private String nome;

    @Email (message = "Email é obrigatório e preicisa ser válido!")
    private String email;

    @NotBlank (message = "Descrição é obrigatória!")
    @Max(400)
    private String descricao;

    private final Date instanteregistro = new Date();


    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getDescricao() { return descricao; }

    public Date getInstanteregistro() { return instanteregistro; }
}
