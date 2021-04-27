package br.com.zupacademy.jessica.casadocodigo.repositories;

import br.com.zupacademy.jessica.casadocodigo.models.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
