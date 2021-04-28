package br.com.zupacademy.jessica.casadocodigo.repositories;

import br.com.zupacademy.jessica.casadocodigo.models.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
}
