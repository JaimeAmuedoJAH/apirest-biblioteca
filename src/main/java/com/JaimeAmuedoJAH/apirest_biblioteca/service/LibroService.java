package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibro{

    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> saveAllLibros(List<Libro> libroList) {
        return libroRepository.saveAll(libroList);
    }

    /*Importante esta estructura para que al recoger datos se muestren con el formato del DTO*/
    @Override
    public List<LibroDTO> findAll() {
        return libroRepository.findAll()
                .stream()
                .map(LibroDTO::new)
                .toList();
    }

    @Override
    public LibroDTO findById(Integer id) {
        return libroRepository.findById(id)
                .map(LibroDTO::new)
                .orElse(null);
    }

    @Override
    public Libro updateLibro(Libro libro) {
        Libro libroBD =libroRepository.findById(libro.getId()).get();

        libroBD.setAutor(libro.getAutor());
        libroBD.setDescripcion(libro.getDescripcion());
        libroBD.setGenero(libro.getGenero());
        libroBD.setTitulo(libro.getTitulo());

        return libroRepository.save(libroBD);
    }

    @Override
    public void deleteById(Integer id) {
        libroRepository.deleteById(id);
    }
}
