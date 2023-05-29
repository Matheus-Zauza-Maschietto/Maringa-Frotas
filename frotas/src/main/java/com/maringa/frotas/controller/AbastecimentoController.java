package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Abastecimento;
import com.maringa.frotas.service.AbastecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService service;

    @GetMapping
    public ResponseEntity<List<Abastecimento>> findAllAbastecimento(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abastecimento> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{id}/veiculos")
    public ResponseEntity<List<Abastecimento>> findByIdVeiculo(@PathVariable Long id){
        return ResponseEntity.ok(service.findByIdVeiculo(id));
    }

    @PostMapping
    public ResponseEntity<Abastecimento> realizarAbastecimento(@RequestBody Abastecimento abastecimento){

        Abastecimento salvo = service.saveAbastecimento(abastecimento);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdAbastecimento()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }

}
