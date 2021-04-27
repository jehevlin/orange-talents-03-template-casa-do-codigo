package br.com.zupacademy.jessica.casadocodigo.requests;

import br.com.zupacademy.jessica.casadocodigo.models.Autor;
import br.com.zupacademy.jessica.casadocodigo.models.Categoria;
import br.com.zupacademy.jessica.casadocodigo.models.Livro;
import br.com.zupacademy.jessica.casadocodigo.requests.validators.MustBeUnique;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastrarLivroRequest {

    @NotBlank
    @MustBeUnique(domainClass = Livro.class, fieldName = "titulo", message = "Autor precisa ser único")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int paginas;

    @NotBlank
    @MustBeUnique(domainClass = Livro.class, fieldName = "isbn", message = "ISBN precisa ser único")
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    private Categoria categoria;

    private Autor autor;

    public String getTitulo() { return titulo; }

    public String getResumo() { return resumo; }

    public String getSumario() { return sumario; }

    public BigDecimal getPreco() { return preco; }

    public int getPaginas() { return paginas; }

    public String getIsbn() { return isbn; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }

    public Categoria getCategoria() { return categoria; }

    public Autor getAutor() { return autor; }

    public Livro toModel() {
        return new Livro(titulo, resumo,sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
    }
}
