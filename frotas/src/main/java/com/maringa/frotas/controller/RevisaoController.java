package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.Insert.RevisaoInsertDTO;
import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.EmpresaRevisao;
import com.maringa.frotas.domain.Revisao;
import com.maringa.frotas.repository.TipoRevisaoRepository;
import com.maringa.frotas.service.EmpresaRevisaoService;
import com.maringa.frotas.service.FrotaService;
import com.maringa.frotas.service.RevisaoService;
import com.maringa.frotas.service.TipoRevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/manutencoes")
public class RevisaoController {

    @Autowired
    private RevisaoService service;

    @Autowired
    private TipoRevisaoService serviceTipo;

    @Autowired
    private FrotaService serviceVeiculo;

    @Autowired
    private EmpresaRevisaoService serviceEmpresa;

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

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Revisao> salvarRevisao(@RequestBody RevisaoInsertDTO revisaodto){

        Revisao revisao = new Revisao();
        revisao.setIdTipoRevisao(serviceTipo.findbyId(revisaodto.getTipoManutencao()));
        revisao.setDataRevisao(revisaodto.getDataRevisao());
        revisao.setDescricaoRevi(revisaodto.getDescricao());
        revisao.setCusto(revisaodto.getValor());
        revisao.setIdFrota(serviceVeiculo.findVeiculoByPlaca(revisaodto.getPlaca()));
        revisao.setIdEmpRevisao(serviceEmpresa.findById(revisaodto.getIdEmpresa()));

        Revisao salvo = service.saveRevisao(revisao);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdRevisao()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }


}
