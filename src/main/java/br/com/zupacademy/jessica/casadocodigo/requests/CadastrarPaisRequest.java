package br.com.zupacademy.jessica.casadocodigo.requests;

import br.com.zupacademy.jessica.casadocodigo.models.Pais;
import br.com.zupacademy.jessica.casadocodigo.requests.validators.MustBeUnique;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CadastrarPaisRequest {

    @Id
    @NotBlank(message = "Nome do País é obrigatorio")
    @MustBeUnique(domainClass = Pais.class, fieldName = "nome", message = "Pais já cadastrado")
    private String nome;

    public Pais toModel() { return new Pais(nome); }

    public String getNome() { return nome; }

}
