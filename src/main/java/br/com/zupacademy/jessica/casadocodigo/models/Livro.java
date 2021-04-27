package br.com.zupacademy.jessica.casadocodigo.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int paginas,
                 String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
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
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() { }

    public long getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getResumo() { return resumo; }

    public String getSumario() { return sumario; }

    public BigDecimal getPreco() { return preco; }

    public int getPaginas() { return paginas; }

    public String getIsbn() { return isbn; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }

    public Categoria getCategoria() { return categoria; }

    public Autor getAutor() { return autor; }
}
