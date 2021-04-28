package br.com.zupacademy.jessica.casadocodigo.requests.validators;

import br.com.zupacademy.jessica.casadocodigo.models.Estado;
import br.com.zupacademy.jessica.casadocodigo.requests.CadastrarEstadoRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoUnicoPorPaisValidator implements ConstraintValidator<EstadoUnicoPorPais, CadastrarEstadoRequest> {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(CadastrarEstadoRequest estado, ConstraintValidatorContext constraintValidatorContext) {
        final String colunaEstado = "nome";
        final String colunaPais = "nome";
        Query query = manager.createQuery(
                "select 1 from " + Estado.class.getName() + " where " + colunaEstado + " = :estado and " + colunaPais + " = :pais");
        query.setParameter("estado", estado.getNome());
        query.setParameter("pais", estado.getPais().getNome());
        List<?> result = query.getResultList();
        return result.isEmpty();
    }
}
