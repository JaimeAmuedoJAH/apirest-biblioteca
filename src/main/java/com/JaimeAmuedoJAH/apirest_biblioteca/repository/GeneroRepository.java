package com.JaimeAmuedoJAH.apirest_biblioteca.repository;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad {@link Genero}.
 *
 * Extiende de {@link JpaRepository} para manejar las operaciones CRUD
 * sobre la tabla "genero".
 */

public interface GeneroRepository extends JpaRepository<Genero, Integer> {


}
