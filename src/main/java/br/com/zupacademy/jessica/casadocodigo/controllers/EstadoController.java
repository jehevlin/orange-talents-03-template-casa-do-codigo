package br.com.zupacademy.jessica.casadocodigo.controllers;

import br.com.zupacademy.jessica.casadocodigo.models.Estado;
import br.com.zupacademy.jessica.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.jessica.casadocodigo.requests.CadastrarEstadoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "estados")
public class EstadoController {

    private final EstadoRepository repository;

    public EstadoController (EstadoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarEstado(@Valid @RequestBody CadastrarEstadoRequest request) {
        Estado estado = repository.save(request.toModel());
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }
}
