package br.com.zupacademy.jessica.casadocodigo.requests.validator;

import br.com.zupacademy.jessica.casadocodigo.repositories.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeCategoriaUnicoValidator implements ConstraintValidator<NomeCategoriaUnico, String> {

    private final CategoriaRepository repository;

    public NomeCategoriaUnicoValidator(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByNome(nome);
    }
}
