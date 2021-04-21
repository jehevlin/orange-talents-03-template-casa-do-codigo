package br.com.zupacademy.jessica.casadocodigo.requests;

import br.com.zupacademy.jessica.casadocodigo.models.Categoria;
import br.com.zupacademy.jessica.casadocodigo.requests.validator.NomeCategoriaUnico;

import javax.validation.constraints.NotBlank;

public class CadastrarCategoriaRequest {
    @NotBlank(message = "Nome é obrigatório!")
    @NomeCategoriaUnico
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
