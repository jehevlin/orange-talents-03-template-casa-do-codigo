package br.com.zupacademy.jessica.casadocodigo.repositories;

import br.com.zupacademy.jessica.casadocodigo.models.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
