package com.JaimeAmuedoJAH.apirest_biblioteca.controller;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.AutorDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;
import com.JaimeAmuedoJAH.apirest_biblioteca.service.IAutor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutorController {

    private IAutor iAutor;

    public AutorController(IAutor iAutor) {
        this.iAutor = iAutor;
    }

    @PostMapping("/create/autor")
    public Autor saveAutor(@RequestBody Autor autor){
        return iAutor.saveAutor(autor);
    }

    @PostMapping("/create/listaautores")
    public List<Autor> saveAllAutores(List<Autor>autorList){
        return iAutor.saveAllAutores(autorList);
    }

    @GetMapping("/read/autores")
    public List<AutorDTO> findAll(){
        return iAutor.findAll();
    }

    @GetMapping("/read/autor")
    public AutorDTO findById(@RequestParam Integer id){

        return iAutor.findById(id);
    }

    @PutMapping("/update/autor")
    public Autor updateAutor(@RequestBody Autor autor){
        return iAutor.updateAutor(autor);
    }

    @DeleteMapping("/delete/autor")
    public void deleteById(@RequestParam Integer id){
        iAutor.deleteById(id);
    }
}
