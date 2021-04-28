package br.com.zupacademy.jessica.casadocodigo.controllers;

import br.com.zupacademy.jessica.casadocodigo.models.Livro;
import br.com.zupacademy.jessica.casadocodigo.repositories.LivroRepository;
import br.com.zupacademy.jessica.casadocodigo.requests.CadastrarLivroRequest;
import br.com.zupacademy.jessica.casadocodigo.responses.DetalheLivroResponse;
import br.com.zupacademy.jessica.casadocodigo.responses.LivroResponse;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="livros" )
@Transactional
public class LivroController {

    private final LivroRepository repository;
    private final EntityManager em;

    public LivroController(LivroRepository repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@Valid @RequestBody CadastrarLivroRequest request) {
        Livro livro = repository.save(request.toModel());
        em.refresh(livro);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarLivros(){
        List<LivroResponse> livros = new ArrayList<>();
        for (Livro livro : repository.findAll()) {
            livros.add(new LivroResponse(livro.getId(), livro.getTitulo()));
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id){
        Optional<Livro> optional = repository.findById(id);
        if (optional.isPresent()){
            Livro livro = optional.get();
            return new ResponseEntity<>(new DetalheLivroResponse(livro.getId(), livro.getTitulo(),
                    livro.getResumo(), livro.getAutor().getNome(), livro.getAutor().getDescricao(),
                    livro.getPreco(), livro.getSumario(), livro.getPaginas(), livro.getIsbn()), HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }
}
