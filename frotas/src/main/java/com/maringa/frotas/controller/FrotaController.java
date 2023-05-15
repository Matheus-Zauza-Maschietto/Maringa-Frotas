package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.service.FrotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/frota")
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

}

