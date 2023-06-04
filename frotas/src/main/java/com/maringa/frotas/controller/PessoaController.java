package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.FuncionarioDTO;
import com.maringa.frotas.DTO.Insert.FuncionarioInsertDTO;
import com.maringa.frotas.domain.Pessoa;
import com.maringa.frotas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


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
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody FuncionarioInsertDTO pessoaDTO){
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

