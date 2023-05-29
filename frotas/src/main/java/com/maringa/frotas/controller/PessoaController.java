package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.DTO.FuncionarioDTO;
import com.maringa.frotas.DTO.InsertPessoaDTO;
import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.Pessoa;
import com.maringa.frotas.service.FrotaService;
import com.maringa.frotas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class PessoaController {

    @Autowired
    private PessoaService service;


    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> mostrarPessoa(){
        List<FuncionarioDTO> pessoaDTO = service.findAllPessoa();

        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> mostrarPessoaById(@PathVariable Long id){
        Object pessoa = service.findAllPessoa();
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody InsertPessoaDTO pessoaDTO){
        Pessoa salvo = service.salvarPessoa(pessoaDTO);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdPessoa()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id){
        service.deletarPessoa(id);

        return  ResponseEntity.noContent().build();

    }

}

