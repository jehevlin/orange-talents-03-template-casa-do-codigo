package br.com.zupacademy.jessica.casadocodigo.controllers;

import br.com.zupacademy.jessica.casadocodigo.models.Livro;
import br.com.zupacademy.jessica.casadocodigo.repositories.LivroRepository;
import br.com.zupacademy.jessica.casadocodigo.requests.CadastrarLivroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path ="livro" )
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
}
