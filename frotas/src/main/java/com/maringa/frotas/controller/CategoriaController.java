package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.Marca;
import com.maringa.frotas.service.CategoriaService;
import com.maringa.frotas.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
