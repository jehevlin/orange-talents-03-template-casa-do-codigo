package br.com.zupacademy.jessica.casadocodigo.novoautor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(path ="Autor")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    public AutorController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAutor (@Valid @RequestBody Autor autor) {
        manager.persist(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
}
