package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.IGenero;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneroController {

    private IGenero iGenero;

    public GeneroController(IGenero iGenero) {
        this.iGenero = iGenero;
    }

    @PostMapping("create/genero")
    public Genero saveGenero(@RequestBody Genero genero){
        return iGenero.saveGenero(genero);
    }

    @PostMapping("create/listageneros")
    public List<Genero> saveAllGeneros(@RequestBody List<Genero> generoList){
        return iGenero.saveAllGeneros(generoList);
    }

    @GetMapping("/read/generos")
    public List<GeneroDTO> findAll(){
        return iGenero.findAll();
    }

    @GetMapping("/read/genero/{id}")
    public GeneroDTO findById(@PathVariable Integer id){
        return iGenero.findById(id);
    }

    @PutMapping("/update/genero")
    public Genero updateGenero(@RequestBody Genero genero){
        return iGenero.updateGenero(genero);
    }

    @DeleteMapping("/delete/genero/{id}")
    public void deleteById(@PathVariable Integer id){
        iGenero.deleteById(id);
    }
}
