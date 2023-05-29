package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.EmpresaDTO;
import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.EmpresaRevisao;
import com.maringa.frotas.domain.Uso;
import com.maringa.frotas.service.EmpresaRevisaoService;
import com.maringa.frotas.service.UsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/empresas")
public class EmpresaRevisaoController {

    @Autowired
    private EmpresaRevisaoService service;

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> findAllEmpresaDTO(){
        return ResponseEntity.ok(service.findAllDTO());
    }

    @GetMapping("/empresas")
    public ResponseEntity<List<EmpresaRevisao>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaRevisao> findByIdEmpresa(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaRevisao> salvarEmpresa(@RequestBody EmpresaRevisao empresa){

        EmpresaRevisao salvo = service.saveEmpresa(empresa);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdEmpRevisao()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id){
        service.deletarEmpresa(id);

        return  ResponseEntity.noContent().build();

    }
}
