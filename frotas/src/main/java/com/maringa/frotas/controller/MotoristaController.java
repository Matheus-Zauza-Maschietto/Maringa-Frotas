package com.maringa.frotas.controller;

import com.maringa.frotas.service.MotoristaService;
import com.maringa.frotas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @GetMapping
    public ResponseEntity<Object> mostrar(){
        Object motorista = service.findAllMotorista();
        return ResponseEntity.ok(motorista);
    }


}

