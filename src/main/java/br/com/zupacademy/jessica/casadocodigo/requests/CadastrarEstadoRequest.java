package br.com.zupacademy.jessica.casadocodigo.requests;

import br.com.zupacademy.jessica.casadocodigo.models.Estado;
import br.com.zupacademy.jessica.casadocodigo.models.Pais;
import br.com.zupacademy.jessica.casadocodigo.requests.validators.EstadoUnicoPorPais;
import br.com.zupacademy.jessica.casadocodigo.requests.validators.MustBeUnique;

import javax.validation.constraints.NotBlank;

@EstadoUnicoPorPais
public class CadastrarEstadoRequest {

    @NotBlank(message = "Nome do Estado é obrigatorio")
 //   @MustBeUnique(domainClass = Estado.class, fieldName = "nome", message = "Estado já cadastrado") ?
    private String nome;

    private Pais pais;

    public Estado toModel() { return new Estado(nome, pais); }

    public String getNome() { return nome; }

    public Pais getPais () { return pais; }
}
