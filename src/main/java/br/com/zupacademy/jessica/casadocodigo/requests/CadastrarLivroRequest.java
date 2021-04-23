package br.com.zupacademy.jessica.casadocodigo.requests;

import br.com.zupacademy.jessica.casadocodigo.models.Livro;
import br.com.zupacademy.jessica.casadocodigo.requests.validators.MustBeUnique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CadastrarLivroRequest {

    @NotBlank
    @MustBeUnique(domainClass = Livro.class, fieldName = "titulo", message = "0000")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotBlank
    @Size(min = 20)
    private Double preco;

    @NotBlank
    @Size(min = 100)
    private Long paginas;

    @NotBlank
    @MustBeUnique(domainClass = Livro.class, fieldName = "isbn", message = "0000")
    private String isbn;

    //data que vai entrar no ar precisa ser no futuro
    private LocalDate dataPublicacao;

    private Long idCategoria;

    private Long idAutor;

    public String getTitulo() { return titulo; }

    public String getResumo() { return resumo; }

    public String getSumario() { return sumario; }

    public Double getPreco() { return preco; }

    public Long getPaginas() { return paginas; }

    public String getIsbn() { return isbn; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }

    public Long getIdCategoria() { return idCategoria; }

    public Long getIdAutor() { return idAutor; }

    public Livro toModel() {
        return new Livro(titulo, resumo,sumario, preco, paginas, isbn, dataPublicacao, idCategoria, idAutor);
    }
}
