package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Posto;
import com.maringa.frotas.service.PostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postos")
public class PostoController {

    @Autowired
    private PostoService service;

    @GetMapping
    public ResponseEntity<List<Posto>> findAllPosto(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posto> findByIdPosto(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
