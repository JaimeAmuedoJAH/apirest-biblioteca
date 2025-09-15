package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.AutorDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.LanzaExcepciones;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.IAutor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Autores", description = "Gestión de autores de libros")
public class AutorController {

    private IAutor iAutor;

    public AutorController(IAutor iAutor) {
        this.iAutor = iAutor;
    }

    @Operation(summary = "Crea un Autor nuevo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre y los apellidos no pueden estar vacíos"),
            @ApiResponse(responseCode = "400", description = "El nombre tiene que tener entre 2 y 50 caracteres"),
            @ApiResponse(responseCode = "400", description = "Los apellidos tiene que tener entre 2 y 50 caracteres"),
    })
    @PostMapping("/create/autor")
    public Autor saveAutor(@RequestBody Autor autor){
        return iAutor.saveAutor(autor);
    }

    @Operation(summary = "Crea una lista de autores nuevos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre y los apellidos no pueden estar vacíos"),
            @ApiResponse(responseCode = "400", description = "El nombre tiene que tener entre 2 y 50 caracteres"),
            @ApiResponse(responseCode = "400", description = "Los apellidos tiene que tener entre 2 y 50 caracteres"),
    })
    @PostMapping("/create/listaautores")
    public List<Autor> saveAllAutores(List<Autor>autorList){
        return iAutor.saveAllAutores(autorList);
    }

    @Operation(summary = "Lista todos los autores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No existe ningun registro"),
    })
    @GetMapping("/read/autores")
    public List<AutorDTO> findAll(){
        return iAutor.findAll();
    }

    @Operation(summary = "Busca un autor por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Autor con id 0 no encontrado")
    })
    @GetMapping("/read/autor")
    public AutorDTO findById(@RequestParam Integer id){
        return iAutor.findById(id);
    }

    @Operation(summary = "Actualiza un autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Género no encontrado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para actualizar el registro"),
    })
    @PutMapping("/update/autor")
    public Autor updateAutor(@RequestBody Autor autor){
        return iAutor.updateAutor(autor);
    }

    @Operation(summary = "Eliminar un autor por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Autor no encontrado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para borrar el registro"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @DeleteMapping("/delete/autor")
    public void deleteById(@RequestParam Integer id){
        iAutor.deleteById(id);
    }
}
