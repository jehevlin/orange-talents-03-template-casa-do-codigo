package br.com.zupacademy.jessica.casadocodigo.requests.validator;

import br.com.zupacademy.jessica.casadocodigo.repositories.AutorRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private final AutorRepository repository;

    public EmailUnicoValidator(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByEmail(email);
    }
}
