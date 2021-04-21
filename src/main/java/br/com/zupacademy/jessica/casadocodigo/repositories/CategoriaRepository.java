package br.com.zupacademy.jessica.casadocodigo.repositories;

import br.com.zupacademy.jessica.casadocodigo.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    boolean existsByNome(String nome);
}
