package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Posto;
import com.maringa.frotas.domain.Uso;
import com.maringa.frotas.service.PostoService;
import com.maringa.frotas.service.UsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usos")
public class UsoController {

    @Autowired
    private UsoService service;

    @GetMapping
    public ResponseEntity<List<Uso>> findAllUso(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Uso> findByIdUso(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
