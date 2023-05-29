package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Revisao;
import com.maringa.frotas.service.RevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/revisoes")
public class RevisaoController {

    @Autowired
    private RevisaoService service;


    @GetMapping
    public ResponseEntity<List<Revisao>> findAllRevisao(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revisao> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<List<Revisao>> findByIdVeiculo(@PathVariable Long id){
        return ResponseEntity.ok(service.findByIdVeiculo(id));
    }


}
