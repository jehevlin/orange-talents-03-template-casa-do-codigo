package br.com.zupacademy.jessica.casadocodigo.repositories;

import br.com.zupacademy.jessica.casadocodigo.models.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
}
