package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.DTO.FrotaViagemDTO;
import com.maringa.frotas.DTO.Insert.FrotaInsertDTO;
import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.service.FrotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/veiculos")
public class FrotaController {

    @Autowired
    private FrotaService service;

    @GetMapping
    public ResponseEntity<List<FrotaAllDTO>> mostrar(){
        List<FrotaAllDTO> frota = service.findAllFrota().stream()
                .sorted(Comparator.comparing(FrotaAllDTO::getDataAdquirido))
                .collect(Collectors.toList());

        return ResponseEntity.ok(frota);
    }
    @GetMapping("/maiorQueAMedia")
    public ResponseEntity<List<FrotaAllDTO>> maiorQueAMedia(){
        List<FrotaAllDTO> frota = service.findVeiculosKmMaiorQueMedia().stream()
                .sorted(Comparator.comparing(FrotaAllDTO::getKmRodado))
                .collect(Collectors.toList());

        return ResponseEntity.ok(frota);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Frota> getByPlaca(@PathVariable String placa){

        return ResponseEntity.ok(service.findVeiculoByPlaca(placa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frota> getById(@PathVariable Long id){

        return ResponseEntity.ok(service.findVeiculoById(id));
    }

    @GetMapping("/{id}/viagens")
    public ResponseEntity<FrotaViagemDTO> getViagensByVeiculo(@PathVariable Long id){
        return ResponseEntity.ok(service.viagensVeiculo(id));
    }

    @PostMapping
    public ResponseEntity<Frota> salvarVeiculo(@RequestBody FrotaInsertDTO veiculoDTO){

        Frota salvo = service.saveFrota(veiculoDTO);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdFrota()).toUri();

        return ResponseEntity.created(uri).body(salvo);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id){
        service.deletarVeiculo(id);

        return  ResponseEntity.noContent().build();

    }

}

