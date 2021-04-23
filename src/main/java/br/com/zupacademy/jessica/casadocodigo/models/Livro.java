package br.com.zupacademy.jessica.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Livro {

    public Livro(String titulo, String resumo, String sumario, Double preco, Long paginas,
                 String isbn, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    //unico
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotBlank
    //@Size(min = 20) ?? preço é obrigatorio e o minimo é 20
    private Double preco;

    @NotBlank
    @Size(min = 100)
    private Long paginas;

    @NotBlank
    //unico
    //formato livre
    private String isbn;

    //data que vai entrar no ar precisa ser no futurp
    private LocalDate dataPublicacao;

    @NotBlank //categoria não pode ser nula
    private Long idCategoria;
    private Categoria categoria;

    @NotBlank //autor não pode ser nulo
    private Long idAutor;
    private Autor autor;

    @Deprecated
    public Livro() {

    }
}
