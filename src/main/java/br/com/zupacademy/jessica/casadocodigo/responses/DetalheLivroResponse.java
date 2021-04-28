package br.com.zupacademy.jessica.casadocodigo.responses;

import java.math.BigDecimal;

public class DetalheLivroResponse {

    private Long id;
    private String titulo;
    private String resumo;
    private String nomeAutor;
    private String descricaoAutor;
    private BigDecimal preco;
    private String sumario;
    private int numeroPaginas;
    private String isbn;

    public DetalheLivroResponse(Long id, String titulo, String resumo, String nomeAutor, String descricaoAutor,
                                BigDecimal preco, String sumario, int numeroPaginas, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.nomeAutor = nomeAutor;
        this.descricaoAutor = descricaoAutor;
        this.preco = preco;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getSumario() {
        return sumario;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }
}
