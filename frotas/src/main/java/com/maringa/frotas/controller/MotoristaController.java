package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.MotoristaDTO;
import com.maringa.frotas.DTO.MotoristaViagemDTO;
import com.maringa.frotas.service.MotoristaService;
import com.maringa.frotas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @GetMapping
    public ResponseEntity<List<MotoristaDTO>> mostrar(){
        List<MotoristaDTO> motorista = service.findAllMotorista();
        return ResponseEntity.ok(motorista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDTO> mostrarMotoristaById(@PathVariable Long id){
        MotoristaDTO motorista = service.findById(id);
        return ResponseEntity.ok(motorista);
    }

    @GetMapping("/{id}/viagens")
    public ResponseEntity<MotoristaViagemDTO> getViagensByMotorista(@PathVariable Long id){
        return ResponseEntity.ok(service.viagemMotorista(id));
    }



}

