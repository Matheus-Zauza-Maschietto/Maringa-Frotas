package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Marca;
import com.maringa.frotas.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> findMarcas(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findbyId(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Marca> salvarMarca(@RequestBody Marca marca){

        Marca salvo = service.saveMarca(marca);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdMarca()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }

}
