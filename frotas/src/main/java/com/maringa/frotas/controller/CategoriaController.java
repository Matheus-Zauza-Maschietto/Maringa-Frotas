package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Abastecimento;
import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.Marca;
import com.maringa.frotas.service.CategoriaService;
import com.maringa.frotas.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/modelos")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findMarcas(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> findMarcasId(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria){

        Categoria salvo = service.saveCategoria(categoria);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdCategoria()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }

}
