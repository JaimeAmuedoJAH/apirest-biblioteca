package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.ILibro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibroController {

    private ILibro iLibro;

    public LibroController(ILibro iLibro) {
        this.iLibro = iLibro;
    }

    @PostMapping("/create/libro")
    public Libro saveLibro(@RequestBody Libro libro){
        return iLibro.saveLibro(libro);
    }

    @PostMapping("/create/listalibros")
    public List<Libro> saveAllLibros(List<Libro> libroList){
        return iLibro.saveAllLibros(libroList);
    }

    @GetMapping("/read/libros")
    public List<LibroDTO> findAll(){

        return iLibro.findAll();
    }
    @GetMapping("/read/libro/{id}")
    public LibroDTO findById(@PathVariable Integer id){
        return iLibro.findById(id);
    }

    @PutMapping("/update/libro")
    public Libro updateLibro(@RequestBody Libro libro){
        return iLibro.updateLibro(libro);
    }

    @DeleteMapping("/delete/libro/{id}")
    public void deleteById(@PathVariable Integer id){
        iLibro.deleteById(id);
    }
}
