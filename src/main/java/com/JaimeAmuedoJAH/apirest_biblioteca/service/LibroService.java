package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.LanzaExcepciones;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.AutorRepository;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.GeneroRepository;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de libros.
 *
 * Define operaciones CRUD para la entidad Libro,
 * trabajando con objetos {@link LibroDTO}.
 */

@Service
public class LibroService implements ILibro{

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Libro saveLibro(Libro libro) {
        if(libro.getTitulo().isBlank()){
            LanzaExcepciones.lanzarBadRequest("El nombre del género no puede estar vacío");
        }else if(libro.getTitulo().length() < 2 || libro.getTitulo().length() > 150) {
            LanzaExcepciones.lanzarBadRequest("El titulo tiene que estar entre 2 y 150 caracteres");
        }else if(libro.getAutor().getNombre().length() < 2 || libro.getAutor().getNombre().length() > 50) {
            LanzaExcepciones.lanzarBadRequest("El nombre de autor tiene que estar entre 2 y 50 caracteres");
        }else if(libro.getAutor().getApellidos().length() < 2 || libro.getAutor().getApellidos().length() > 150) {
            LanzaExcepciones.lanzarBadRequest("Los apellidos de autor tiene que estar entre 2 y 150 caracteres");
        }else if(libro.getGenero().getNombre().length() < 2 || libro.getGenero().getNombre().length() > 50) {
            LanzaExcepciones.lanzarBadRequest("El titulo tiene que estar entre 2 y 150 caracteres");
        }

        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> saveAllLibros(List<Libro> libroList) {
        for(Libro libro : libroList){
            if(libro.getTitulo().isBlank() || libro.getGenero().getNombre().isBlank() || libro.getAutor().getNombre().isBlank() ||libro.getAutor().getApellidos().isBlank()){
                LanzaExcepciones.lanzarBadRequest("Debes rellenar todos los campos");
            }
        }

        return libroRepository.saveAll(libroList);
    }

    /*Importante esta estructura para que al recoger datos se muestren con el formato del DTO*/
    @Override
    public List<LibroDTO> findAll() {
        List<LibroDTO> lista = libroRepository.findAll()
                .stream()
                .map(LibroDTO::new)
                .toList();

        if(lista.isEmpty()){
            LanzaExcepciones.lanzarNotFound("No existe ningun registro");
        }

        return lista;
    }

    @Override
    public LibroDTO findById(Integer id) {
        LibroDTO libro = libroRepository.findById(id)
                .map(LibroDTO::new)
                .orElse(null);

        if(libro == null){
            LanzaExcepciones.lanzarNotFound("Libro", id);
        }
        return libro;
    }

    @Override
    public List<LibroDTO> obtenerLibroPorGenero(Integer id) {
        if (!generoRepository.existsById(id)) {
            LanzaExcepciones.lanzarNotFound("Género no encontrado");
        }else if(generoRepository.findById(id).isEmpty()){
            LanzaExcepciones.lanzarInternal("Debes seleccionar algún género");
        }

        return libroRepository.findByGeneroId(id)
                .stream()
                .map(LibroDTO::new)
                .toList();
    }

    @Override
    public List<LibroDTO> obtenerLibroPorAutor(Integer id) {
        if (!autorRepository.existsById(id)) {
            LanzaExcepciones.lanzarNotFound("No hay libros con el autor indicado");
        }else if(autorRepository.findById(id).isEmpty()){
            LanzaExcepciones.lanzarInternal("Debes seleccionar algún autor");
        }

        return libroRepository.findByAutorId(id)
                .stream()
                .map(LibroDTO::new)
                .toList();
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
