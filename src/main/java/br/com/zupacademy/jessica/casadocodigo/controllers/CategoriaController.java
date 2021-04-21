package br.com.zupacademy.jessica.casadocodigo.controllers;

import br.com.zupacademy.jessica.casadocodigo.models.Categoria;
import br.com.zupacademy.jessica.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.jessica.casadocodigo.requests.CadastrarCategoriaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "Categoria")
public class CategoriaController {
    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> CadastrarCategoria(@Valid @RequestBody CadastrarCategoriaRequest request){
        Categoria categoria = repository.save(request.toModel());
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorField = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(errorField, errorMessage);
        });

        return errors;
    }
}
