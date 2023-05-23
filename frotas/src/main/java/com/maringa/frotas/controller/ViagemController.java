package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Viagem;
import com.maringa.frotas.service.ViagemService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    private ViagemService service;

    @GetMapping
    public ResponseEntity<List<Viagem>> findViagens(){
        return ResponseEntity.ok(service.findAllViagens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> findViagemById(@PathVariable Long id){
        return ResponseEntity.ok(service.findViagemById(id));
    }
}
