package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.BadRequestException;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.ResourceNotFoundException;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.IGenero;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Géneros", description = "Gestión de géneros de libros")
public class GeneroController {

    private IGenero iGenero;

    public GeneroController(IGenero iGenero) {
        this.iGenero = iGenero;
    }

    @Operation(summary = "Crea un genero nuevo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre del género no puede estar vacío")
    })
    @PostMapping("create/genero")
    public Genero saveGenero(@RequestBody Genero genero){
        if(genero.getNombre() == null){
            throw new BadRequestException("El nombre del género no puede estar vacío");
        }
        return iGenero.saveGenero(genero);
    }

    @Operation(summary = "Crea una lista generos nuevos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "El nombre de los géneros no puede estar vacío")
    })
    @PostMapping("create/listageneros")
    public List<Genero> saveAllGeneros(@RequestBody List<Genero> generoList){
        if(generoList.isEmpty()){
            throw new BadRequestException("Rellena al menos un campo");
        }

        for(Genero genero : generoList){
            if(genero.getNombre() == null){
                throw new BadRequestException("El nombre de los géneros no puede estar vacío");
            }
        }
        return iGenero.saveAllGeneros(generoList);
    }

    @Operation(summary = "Lista todos los generos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No existe ningun registro"),
    })
    @GetMapping("/read/generos")
    public List<GeneroDTO> findAll(){

        List<GeneroDTO> lista = iGenero.findAll();

        if(lista.isEmpty()){
            throw new ResourceNotFoundException("No existe ningun registro");
        }
        return  lista;
    }

    @Operation(summary = "Busca un genero por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Genero con id 0 no encontrado")
    })
    @GetMapping("/read/genero")
    public GeneroDTO findById(@RequestParam Integer id){
        GeneroDTO genero = iGenero.findById(id);
        if(genero == null){
            throw new ResourceNotFoundException("genero", id);
        }
        return genero;
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
