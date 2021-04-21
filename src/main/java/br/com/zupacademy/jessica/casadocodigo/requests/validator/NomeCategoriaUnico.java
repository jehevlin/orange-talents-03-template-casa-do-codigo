package br.com.zupacademy.jessica.casadocodigo.requests.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {NomeCategoriaUnicoValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface NomeCategoriaUnico {
    String message() default "Nome da categoria já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
