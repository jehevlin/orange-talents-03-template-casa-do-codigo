package br.com.zupacademy.jessica.casadocodigo.controllers;

import br.com.zupacademy.jessica.casadocodigo.models.Autor;
import br.com.zupacademy.jessica.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.jessica.casadocodigo.requests.CadastrarAutorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "autores")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@Valid @RequestBody CadastrarAutorRequest request) {
        Autor autor = repository.save(request.toModel());
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
}
