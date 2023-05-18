package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.domain.Pessoa;
import com.maringa.frotas.service.FrotaService;
import com.maringa.frotas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Object> mostrar(){
        Object pessoa = service.findAllPessoa();
        return ResponseEntity.ok(pessoa);
    }


}

