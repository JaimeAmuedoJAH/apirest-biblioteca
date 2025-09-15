package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.LanzaExcepciones;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.ILibro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Libros", description = "Gestión de libros")
public class LibroController {

    private ILibro iLibro;

    public LibroController(ILibro iLibro) {
        this.iLibro = iLibro;
    }

    //Falta añadir validaciones
    @Operation(summary = "Crea un libro nuevo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre del género no puede estar vacío"),
            @ApiResponse(responseCode = "400", description = "El titulo tiene que estar entre 2 y 150 caracteres"),
            @ApiResponse(responseCode = "400", description = "El nombre de autor tiene que estar entre 2 y 50 caracteres"),
            @ApiResponse(responseCode = "400", description = "Los apellidos de autor tiene que estar entre 2 y 150 caracteres"),
            @ApiResponse(responseCode = "400", description = "El titulo tiene que estar entre 2 y 150 caracteres")
    })
    @PostMapping("/create/libro")
    public Libro saveLibro(@RequestBody Libro libro){
        return iLibro.saveLibro(libro);
    }

    @Operation(summary = "Crea una lista de libros nuevos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Debes rellenar todos los campos")
    })
    @PostMapping("/create/listalibros")
    public List<Libro> saveAllLibros(List<Libro> libroList){
        return iLibro.saveAllLibros(libroList);
    }

    @Operation(summary = "Lista todos los libros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No existe ningun registro"),
    })
    @GetMapping("/read/libros")
    public List<LibroDTO> findAll(){
        return iLibro.findAll();
    }

    @Operation(summary = "Busca un libro por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Libro con id 0 no encontrado")
    })
    @GetMapping("/read/libro")
    public LibroDTO findById(@RequestParam Integer id){
        return iLibro.findById(id);
    }

    @Operation(summary = "Busca todos los libros de un genero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No exsite ningun registro"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para actualizar el registro"),
            @ApiResponse(responseCode = "500", description = "Debes seleccionar algún género"),
    })
    @GetMapping("/read/libros/genero")
    public List<LibroDTO> obtenerLibroPorGenero(@RequestParam Integer id) {
        return iLibro.obtenerLibroPorGenero(id);
    }

    @Operation(summary = "Busca todos los libros de un autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No hay libros con el autor indicado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para actualizar el registro"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para eliminar el registro"),
            @ApiResponse(responseCode = "500", description = "Debes seleccionar algún autor")
    })
    @GetMapping("/read/libros/autor")
    public List<LibroDTO> obtenerLibroPorAutor(@RequestParam Integer id) {
        return iLibro.obtenerLibroPorAutor(id);
    }

    @Operation(summary = "Actualiza un libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Género no encontrado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para actualizar el registro"),
    })
    @PutMapping("/update/libro")
    public Libro updateLibro(@RequestBody Libro libro){
        return iLibro.updateLibro(libro);
    }

    @Operation(summary = "Eliminar un libro por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Género no encontrado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para borrar el registro"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @DeleteMapping("/delete/libro")
        public void deleteById(@RequestParam Integer id){
        iLibro.deleteById(id);
    }
}
