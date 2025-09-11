package com.JaimeAmuedoJAH.apirest_biblioteca.repository;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByGeneroId(Integer generoId);
    List<Libro> findByAutorId(Integer generoId);
}
