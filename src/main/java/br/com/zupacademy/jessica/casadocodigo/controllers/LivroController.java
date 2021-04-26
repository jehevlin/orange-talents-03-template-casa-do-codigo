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

import javax.validation.Valid;

@RestController
@RequestMapping(path ="livro" )
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@Valid @RequestBody CadastrarLivroRequest request) {
        Livro livro = repository.save(request.toModel());
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }
}
