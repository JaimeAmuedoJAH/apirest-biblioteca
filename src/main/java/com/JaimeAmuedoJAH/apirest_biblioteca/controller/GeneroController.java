package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.GeneroService;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.IGenero;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar géneros literarios.
 *
 * Expone endpoints CRUD para crear, obtener, actualizar y eliminar géneros.
 * Utiliza el servicio {@link GeneroService}.
 */

@RestController
@Tag(name = "Géneros", description = "Gestión de géneros de libros")
public class GeneroController {

    private IGenero iGenero;

    public GeneroController(IGenero iGenero) {
        this.iGenero = iGenero;
    }

    @Operation(summary = "Crea un genero nuevo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre del género no puede estar vacío"),
            @ApiResponse(responseCode = "400", description = "El nombre tiene que estar entre 2 y 50 caracteres")
    })
    @PostMapping("create/genero")
    public Genero saveGenero(@RequestBody Genero genero){
        return iGenero.saveGenero(genero);
    }

    @Operation(summary = "Crea una lista generos nuevos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre de los géneros no puede estar vacío")
    })
    @PostMapping("create/listageneros")
    public List<Genero> saveAllGeneros(@RequestBody List<Genero> generoList){
        return iGenero.saveAllGeneros(generoList);
    }

    @Operation(summary = "Lista todos los generos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No existe ningun registro"),
    })
    @GetMapping("/read/generos")
    public List<GeneroDTO> findAll(){
        return  iGenero.findAll();
    }

    @Operation(summary = "Busca un genero por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Genero con id 0 no encontrado")
    })
    @GetMapping("/read/genero")
    public GeneroDTO findById(@RequestParam Integer id){
        return iGenero.findById(id);
    }

    @Operation(summary = "Actualiza un género")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Género no encontrado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para actualizar el registro"),
    })
    @PutMapping("/update/genero")
    public Genero updateGenero(@RequestBody Genero genero){
        return iGenero.updateGenero(genero);
    }

    @Operation(summary = "Eliminar un género por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Género no encontrado"),
            @ApiResponse(responseCode = "401", description = "No tienes permiso para borrar el registro"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @DeleteMapping("/delete/genero")
    public void deleteById(@RequestParam Integer id){
        iGenero.deleteById(id);
    }
}
