package com.JaimeAmuedoJAH.apirest_biblioteca.repository;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad {@link Autor}.
 *
 * Extiende de {@link JpaRepository} para proporcionar operaciones
 * CRUD automáticas sobre la tabla "autor".
 */

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
