package br.com.zupacademy.jessica.casadocodigo.requests.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {EstadoUnicoPorPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface EstadoUnicoPorPais {
    String message() default "Nome de estado já existe neste país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
